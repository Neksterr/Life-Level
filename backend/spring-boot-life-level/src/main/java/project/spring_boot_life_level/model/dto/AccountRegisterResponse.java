package project.spring_boot_life_level.model.dto;

public record AccountRegisterResponse(Long id, String username, String email,
                                      project.spring_boot_life_level.model.enums.AccountRole accountRole,
                                      boolean enabled, String plainPass) {
}
