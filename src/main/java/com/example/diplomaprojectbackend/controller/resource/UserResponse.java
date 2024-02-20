package com.example.diplomaprojectbackend.controller.resource;

import com.example.diplomaprojectbackend.shared.UserType;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private UserType userType;
}
