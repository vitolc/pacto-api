package com.vitulc.pactotestapi.dtos;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(@NotBlank(message = "An email is required to login.") String email,
                       @NotBlank(message = "A password is required to login.") String password
) {
}
