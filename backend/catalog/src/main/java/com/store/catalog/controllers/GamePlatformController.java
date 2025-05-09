package com.store.catalog.controllers;

import com.store.catalog.dto.GamePlatformModelDto;
import com.store.catalog.models.GamePlatformModel;
import com.store.catalog.services.GamePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gamePlatform")
public class GamePlatformController {

    @Autowired
    GamePlatformService gamePlatformService;

    public ResponseEntity<GamePlatformModel> addGamePlatform(@RequestBody GamePlatformModelDto gamePlatformModelDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(gamePlatformService.save(gamePlatformModelDto));
    }
}
