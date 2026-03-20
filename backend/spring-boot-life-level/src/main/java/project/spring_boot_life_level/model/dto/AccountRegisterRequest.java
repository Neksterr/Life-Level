package project.spring_boot_life_level.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import project.spring_boot_life_level.model.enums.AccountRole;

public record AccountRegisterRequest(@NotBlank String email,
                                     @NotBlank String username,
                                     @NotBlank String password,
                                     @NotNull AccountRole accountRole) {
}
