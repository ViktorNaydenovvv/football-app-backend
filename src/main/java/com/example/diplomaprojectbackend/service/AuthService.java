package com.example.diplomaprojectbackend.service;

import com.example.diplomaprojectbackend.controller.resource.AuthResponse;
import com.example.diplomaprojectbackend.controller.resource.SignInRequest;

public interface AuthService {
    AuthResponse signIn(SignInRequest signInData);
}
