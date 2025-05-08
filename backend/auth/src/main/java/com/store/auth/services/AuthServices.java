package com.store.auth.services;

import com.store.auth.dto.AuthRecordDto;
import com.store.auth.dto.AuthRecordRabbitMQ;
import com.store.auth.dto.AuthResponseDto;
import com.store.auth.exceptions.AuthException;
import com.store.auth.models.UserAuthModel;
import com.store.auth.producers.AuthProducer;
import com.store.auth.repositories.AuthRepository;
import com.store.auth.utils.JwtUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    AuthProducer authProducer;

    @Transactional
    public AuthResponseDto saveUser(AuthRecordDto authRecordDto, HttpServletResponse httpServletResponse) {

        UserAuthModel userAuthModel = new UserAuthModel();
        BeanUtils.copyProperties(authRecordDto, userAuthModel);

        if (authRepository.existsByEmail(userAuthModel.getEmail()))
            throw new AuthException("Email already exists");

        userAuthModel.setPasswordHash(passwordEncoder.encode(authRecordDto.password()));
        userAuthModel = authRepository.save(userAuthModel);

        authProducer.publishMessageEmail(userAuthModel);

        String token = jwtUtils.generateToken(userAuthModel.getEmail());

        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60); // 1 day

        httpServletResponse.addCookie(cookie);

        return new AuthResponseDto(token);
    }

    public AuthResponseDto authenticateUser(String email, String password, HttpServletResponse httpServletResponse) {
        UserAuthModel userAuthModel = authRepository.findByEmail(email);
        if (userAuthModel == null) {
            throw new AuthException("User not found with email: " + email);
        }
        if (!passwordEncoder.matches(password, userAuthModel.getPasswordHash())) {
            throw new AuthException("Invalid password");
        }

        String token = jwtUtils.generateToken(email);

        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60); // 1 day

        httpServletResponse.addCookie(cookie);

        return new AuthResponseDto(token);
    }

    public ResponseEntity<?> logout(HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("jwt", null);
        cookie.setMaxAge(0);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        httpServletResponse.addCookie(cookie);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
