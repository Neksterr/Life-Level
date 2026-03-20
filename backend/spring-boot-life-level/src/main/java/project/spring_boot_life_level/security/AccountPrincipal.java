package project.spring_boot_life_level.security;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.spring_boot_life_level.model.enums.AccountRole;

import java.util.Collection;
import java.util.List;

public class AccountPrincipal implements UserDetails {
    private final  Long id;
    private final String username;
    private final String password;
    private final AccountRole accountRole;
    private final boolean enable;

    public AccountPrincipal(Long id, String username, String password, AccountRole accountRole, boolean enable) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountRole = accountRole;
        this.enable = enable;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("Role_" + accountRole.name()));
    }

    @Override
    public  String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isEnabled() {
        return  enable;
    }

    public Long getId() {
        return id;
    }

    public AccountRole getAccountRole() {
        return accountRole;
    }
}
