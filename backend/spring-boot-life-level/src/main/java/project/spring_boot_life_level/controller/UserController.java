package project.spring_boot_life_level.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import project.spring_boot_life_level.model.dto.AccountRegisterRequest;
import project.spring_boot_life_level.model.dto.AccountRegisterResponse;
import project.spring_boot_life_level.service.AccountService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/account")
public class UserController {
    private final AccountService accountService;

    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String displayMessage() {
        return "Hello to Application";
    }
    @PostMapping("/register")
    public AccountRegisterResponse createAccount(@Valid @RequestBody AccountRegisterRequest accountRegisterRequest){
        return accountService.createAccount(accountRegisterRequest);
    }
}
