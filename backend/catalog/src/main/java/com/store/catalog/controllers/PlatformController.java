package com.store.catalog.controllers;

import com.store.catalog.dto.PlatformDto;
import com.store.catalog.models.PlatformModel;
import com.store.catalog.services.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/platform")
public class PlatformController {

    @Autowired
    PlatformService platformService;

    @PostMapping("/addPlatform")
    public ResponseEntity<PlatformModel> addPlatform(@RequestBody PlatformDto platformDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(platformService.save(platformDto));
    }

    @GetMapping("/getAllPlatforms")
    public ResponseEntity<List<PlatformModel>> getAllPlatforms(){
        return ResponseEntity.status(HttpStatus.OK).body(platformService.getAllPlatforms());
    }


}
