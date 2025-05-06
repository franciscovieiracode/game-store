package com.store.auth.services;

import com.store.auth.dto.AuthRecordDto;
import com.store.auth.exceptions.AuthException;
import com.store.auth.models.UserAuthModel;
import com.store.auth.repositories.AuthRepository;
import com.store.auth.utils.JwtUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public String saveUser(AuthRecordDto authRecordDto) {

        UserAuthModel userAuthModel = new UserAuthModel();
        BeanUtils.copyProperties(authRecordDto, userAuthModel);

        if (authRepository.existsByEmail(userAuthModel.getEmail()))
            throw new AuthException("Email already exists");

        userAuthModel.setPasswordHash(passwordEncoder.encode(authRecordDto.passwordHash()));
        authRepository.save(userAuthModel);

        return jwtUtils.generateToken(userAuthModel.getEmail());
    }

    public String authenticateUser(String email, String password) {
        UserAuthModel userAuthModel = authRepository.findByEmail(email);
        if (userAuthModel == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        if (!passwordEncoder.matches(password, userAuthModel.getPasswordHash())) {
            throw new AuthException("Invalid password");
        }

        return jwtUtils.generateToken(email);
    }
}
