package com.store.auth.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthRecordDto(@NotBlank String email,
                            @NotBlank String passwordHash) {
}
