package com.example.diplomaprojectbackend.controller.resource;

import com.example.diplomaprojectbackend.shared.UserType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotEmpty
    @Size(min = 8, max = 64)
    private String email;

    @NotEmpty
    @Size(min = 2, max = 32)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 32)
    private String lastName;

    @NotNull
    @Min(1)
    private Integer age;

    @NotEmpty
    private UserType userType;

    @NotEmpty
    @Size(min = 8, max = 32)
    private String password;
}
