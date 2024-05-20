package com.example.diplomaprojectbackend.controller;

import com.example.diplomaprojectbackend.controller.resource.AuthResponse;
import com.example.diplomaprojectbackend.controller.resource.SignInReq;
import com.example.diplomaprojectbackend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@Valid @RequestBody SignInReq signInData) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.signIn(signInData));
    }
}