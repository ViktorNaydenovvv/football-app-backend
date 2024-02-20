package com.example.diplomaprojectbackend.service;

import com.example.diplomaprojectbackend.controller.resource.LoginUserRequest;
import com.example.diplomaprojectbackend.controller.resource.RegisterUserRequest;
import com.example.diplomaprojectbackend.controller.resource.UserResponse;

public interface UserService {
    UserResponse register(RegisterUserRequest request);
    UserResponse login(LoginUserRequest loginRequest);
    void delete(Long id);
}
