package com.store.catalog.controllers;

import com.store.catalog.dto.GameModelDto;
import com.store.catalog.models.GameModel;
import com.store.catalog.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/findById/{gameId}")
    public ResponseEntity<Optional<GameModel>> getGameId(@PathVariable("gameId") UUID gameId) {
        return ResponseEntity.status(HttpStatus.OK).body(gameService.findById(gameId));
    }
}
