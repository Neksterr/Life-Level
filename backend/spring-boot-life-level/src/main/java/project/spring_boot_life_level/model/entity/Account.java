package project.spring_boot_life_level.model.entity;

import jakarta.persistence.*;
import project.spring_boot_life_level.model.enums.AccountRole;

import java.time.LocalDate;

@Entity
@Table(name = "accounts")
public class Account extends  BaseEntity{
    @Column(name = "email", nullable = false,unique = true)
    private String email;
    @Column(name = "username", nullable = false,unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "account_role", nullable = false)
    private AccountRole accountRole;
    @Column(name = "enabled", nullable = false)
    private boolean isEnabled;
    @Column(name = "created_at",nullable = false)
    private LocalDate createdAt;
    @Column(name = "last_modified", nullable = false)
    private LocalDate lastModifiedDate;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountRole getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(AccountRole accountRole) {
        this.accountRole = accountRole;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
