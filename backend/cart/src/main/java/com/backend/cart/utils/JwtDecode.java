package com.backend.cart.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

@Component
public class JwtDecode {

    private static final String SECRET_KEY = "your-secret-key";

    public DecodedJWT validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        return JWT.require(algorithm)
                .build()
                .verify(token);
    }
}
