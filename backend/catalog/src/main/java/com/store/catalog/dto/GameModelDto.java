package com.store.catalog.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

public record GameModelDto(
        String name,
        @NotBlank String description,
        @NotBlank String publisher,
        @NotBlank String developer,
        @NotBlank String releaseDate,
        List<GamePlatformModelDto> platforms
) {
}
