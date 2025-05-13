package com.backend.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDetailsModel{
    private String name;
    private String gameId;
    private String gameImg;
    private int quantity;
    private String platform;
    private List<GamePlatformModelDto> gamePlatformModels;
}
