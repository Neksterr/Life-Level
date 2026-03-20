package project.spring_boot_life_level.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import project.spring_boot_life_level.model.dto.AccountRegisterRequest;
import project.spring_boot_life_level.model.dto.AccountRegisterResponse;
import project.spring_boot_life_level.model.entity.Account;
import project.spring_boot_life_level.repository.AccountRepository;

import static org.springframework.http.HttpStatus.CONFLICT;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public AccountRegisterResponse createAccount(AccountRegisterRequest accountRegisterRequest){
        Account existingAccount = accountRepository.findByUsername(accountRegisterRequest.username());
        if (existingAccount != null){
            throw  new ResponseStatusException(CONFLICT,"Account already exist");
        }
        String plainPass= "";
        if (accountRegisterRequest.password() != null || !accountRegisterRequest.password().isBlank()){
            plainPass = accountRegisterRequest.password();
        }
        Account account = modelMapper.map(accountRegisterRequest,Account.class);
        account.setPassword(passwordEncoder.encode(plainPass));
        account.setEnabled(true);
        Account saveAccount = accountRepository.save(account);
        return new AccountRegisterResponse(saveAccount.getId(),saveAccount.getUsername(),saveAccount.getEmail(),saveAccount.getAccountRole(),saveAccount.isEnabled(), plainPass);
    }


}
