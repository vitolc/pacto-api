package com.vitulc.pactotestapi.dtos;

import jakarta.validation.constraints.NotBlank;

public record RegisterDto(@NotBlank(message = "A username is required to register.") String username,
                          @NotBlank(message = "An email is required to register.") String email,
                          @NotBlank(message = "A phone number is required to register.") String phone,
                          @NotBlank(message = "A password is required to register.") String password,
                          @NotBlank(message = "Password confirmation required to register.") String confirmPassword) {
}
