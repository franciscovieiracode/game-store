package com.store.backend.controllers;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.store.backend.dto.UserRecordDto;
import com.store.backend.dto.UserResponseDto;
import com.store.backend.models.UserModel;
import com.store.backend.services.UserServices;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/user/")
@RestController
public class UserController {

    @Autowired
    UserServices userServices;


    @GetMapping("getUser")
    public ResponseEntity<UserResponseDto> getUser(Authentication authentication) throws InterruptedException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userServices.getUser(authentication));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userServices.getAllUsers());
    }


}
