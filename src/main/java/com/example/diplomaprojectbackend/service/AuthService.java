package com.example.diplomaprojectbackend.service;

import com.example.diplomaprojectbackend.controller.resource.AuthResponse;
import com.example.diplomaprojectbackend.controller.resource.SignInReq;

public interface AuthService {
    AuthResponse signIn(SignInReq signInData);
}
