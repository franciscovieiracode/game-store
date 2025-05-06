package com.store.auth.controllers;

import com.store.auth.dto.AuthRecordDto;
import com.store.auth.models.UserAuthModel;
import com.store.auth.services.AuthServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthServices authServices;

    @PostMapping("/register")
    public ResponseEntity<String> saveUser(@RequestBody @Valid AuthRecordDto authRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(authServices.saveUser(authRecordDto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthRecordDto authRecordDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(authServices.authenticateUser(authRecordDto.email(), authRecordDto.passwordHash()));

    }
}
