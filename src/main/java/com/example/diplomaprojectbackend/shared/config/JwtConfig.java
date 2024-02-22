package com.example.diplomaprojectbackend.shared.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Key;

@Configuration
public class JwtConfig {
    @Value("4m16ftp129f12k9a64a1ue27120a259c")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    @Bean
    public Key getSecretKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public long getExpiration() {
        return expiration;
    }

    public SignatureAlgorithm getAlgorithm() {
        return SignatureAlgorithm.HS256;
    }
}
