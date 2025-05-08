package com.store.auth.controllers;

import com.store.auth.dto.AuthRecordDto;
import com.store.auth.dto.AuthResponseDto;
import com.store.auth.models.UserAuthModel;
import com.store.auth.services.AuthServices;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    AuthServices authServices;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> saveUser(@RequestBody @Valid AuthRecordDto authRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(authServices.saveUser(authRecordDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody @Valid AuthRecordDto authRecordDto, HttpServletResponse httpServletResponse){
        return ResponseEntity.status(HttpStatus.OK).body(authServices.authenticateUser(authRecordDto.email(), authRecordDto.password(), httpServletResponse));

    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse httpServletResponse){
        return ResponseEntity.status(HttpStatus.OK).body(authServices.logout(httpServletResponse));
    }
}
