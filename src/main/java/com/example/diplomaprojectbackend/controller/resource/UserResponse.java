package com.example.diplomaprojectbackend.controller.resource;

import com.example.diplomaprojectbackend.shared.UserType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private UserType userType;
    private String email;
    private String firstName;
    private String lastName;
    private Integer age;
}
