package com.store.backend.services;

import com.store.backend.models.UserModel;
import com.store.backend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    public List<UserModel> getAllUsers() {return userRepository.findAll();}

}
