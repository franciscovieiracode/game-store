package com.store.auth.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record AuthRecordDto(@NotBlank String email,
                            String password,
                            String name,
                            UUID userId) {
}
