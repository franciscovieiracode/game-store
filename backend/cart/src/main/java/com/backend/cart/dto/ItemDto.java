package com.backend.cart.dto;

import jakarta.validation.constraints.NotBlank;

public record ItemDto(
    @NotBlank String itemId,
    @NotBlank int quantity
) {
}
