package com.store.catalog.dto;

import jakarta.validation.constraints.NotBlank;

public record PlatformDto(
        @NotBlank String platform
) {
}
