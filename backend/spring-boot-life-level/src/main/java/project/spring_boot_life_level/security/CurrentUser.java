package project.spring_boot_life_level.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUser {
    private CurrentUser(){}
    private static AccountPrincipal principal(){
        return (AccountPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    }
    public  static  Long id(){
        return principal().getId();
    }
}
