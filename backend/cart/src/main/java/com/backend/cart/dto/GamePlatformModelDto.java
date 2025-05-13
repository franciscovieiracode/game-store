package com.backend.cart.dto;

import jakarta.validation.constraints.NotBlank;

public record GamePlatformModelDto(
        double price,
        double discount,
        int stock,
        PlatformModelDto platformModel
) {}
