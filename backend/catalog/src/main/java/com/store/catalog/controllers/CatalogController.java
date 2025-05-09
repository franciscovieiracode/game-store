package com.store.catalog.controllers;

import com.store.catalog.models.GameModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

    @GetMapping("/getAllCatalog")
    public ResponseEntity<GameModel> getAllItem(){
        return null;
    }

}
