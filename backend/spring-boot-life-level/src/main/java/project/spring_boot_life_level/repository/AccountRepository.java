package project.spring_boot_life_level.repository;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.spring_boot_life_level.model.entity.Account;

@Repository
public interface AccountRepository  extends JpaRepository<Account,Long> {
    Account findByUsername(@NotBlank java.lang.@NotBlank String username);
}
