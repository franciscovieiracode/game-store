package com.store.backend.services;

import com.store.backend.models.UserModel;
import com.store.backend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public UserModel getUser(Authentication authentication){

        String username = (String) authentication.getPrincipal();

        return userRepository.findByEmail(username);

    }

    public List<UserModel> getAllUsers() {return userRepository.findAll();}

}
