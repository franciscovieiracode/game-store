package com.store.catalog.dto;

import jakarta.validation.constraints.NotBlank;

public record GamePlatformModelDto(
    @NotBlank String name,
    @NotBlank double price,
    @NotBlank double discount,
    @NotBlank int stock,
    @NotBlank String platform
) {
}
