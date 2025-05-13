package com.backend.cart.dto;

import jakarta.validation.constraints.NotBlank;

public record ItemRemoveDto(
        @NotBlank String itemId,
        @NotBlank String platform
) {
}
