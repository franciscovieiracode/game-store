package com.backend.cart.controllers;

import com.backend.cart.dto.ItemDto;
import com.backend.cart.dto.ItemRemoveDto;
import com.backend.cart.models.CartModel;
import com.backend.cart.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/getCart")
    public ResponseEntity<List<CartModel>> getCart(Authentication authentication){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.getAll(authentication));
    }

    @PostMapping("/addItemToCart")
    public ResponseEntity<CartModel> addItemToCart(@RequestBody ItemDto itemDto, Authentication authentication){
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.save(itemDto, authentication));
    }

    @PostMapping("/removeItem")
    public ResponseEntity<CartModel> removeItem(@RequestBody ItemRemoveDto itemRemoveDto, Authentication authentication){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.removeItem(itemRemoveDto, authentication));
    }

}
