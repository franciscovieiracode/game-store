package com.store.catalog.controllers;

import com.store.catalog.dto.GameModelDto;
import com.store.catalog.models.GameModel;
import com.store.catalog.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

    @Autowired
    GameService gameService;

    @GetMapping("/getAllCatalog")
    public ResponseEntity<List<GameModel>> getAllItem(){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.getAllGames());
    }

    @PostMapping("/addGame")
    public ResponseEntity<GameModel> addGame(@RequestBody GameModelDto gameModelDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.save(gameModelDto));
    }

}
