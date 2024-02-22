package com.example.diplomaprojectbackend.controller.resource;

import com.example.diplomaprojectbackend.entity.AbstractUser;
import lombok.Data;

@Data
public class AuthResponse {
    private final AbstractUser user;
    private final String token;
}
