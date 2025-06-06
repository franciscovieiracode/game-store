package com.store.backend.services;

import com.store.backend.dto.UserRecordDto;
import com.store.backend.dto.UserResponseDto;
import com.store.backend.models.UserModel;
import com.store.backend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public UserResponseDto getUser(Authentication authentication) throws InterruptedException {

        String email = (String) authentication.getPrincipal();

        UserModel user = userRepository.findByEmail(email);

        int retries = 5;
        while (user == null && retries > 0) {
            user = userRepository.findByEmail(email);
            if (user == null) {
                Thread.sleep(500); // wait 500 ms
                retries--;
            }
        }

        return new UserResponseDto(user.getName(), user.getEmail(), user.getBalance(), user.getCreatedAt());

    }

    public List<UserModel> getAllUsers() {return userRepository.findAll();}

    @Transactional
    public UserModel save(UserRecordDto userRecordDto){

        UserModel userModel = new UserModel();

        userModel.setUserId(userRecordDto.userId());
        userModel.setEmail(userRecordDto.email());
        userModel.setName(userRecordDto.name());
        userModel.setCreatedAt(LocalDateTime.now());

        return userRepository.save(userModel);
    }
}
