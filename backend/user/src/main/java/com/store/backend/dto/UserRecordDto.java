package com.store.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UserRecordDto(@NotBlank String name,
                            @NotBlank @Email String email,
                            @NotBlank UUID userId) {
}
