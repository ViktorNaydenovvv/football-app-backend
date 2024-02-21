package com.example.diplomaprojectbackend.controller.resource;

import com.example.diplomaprojectbackend.shared.UserType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserDto {
    @NotNull
    @Size(min = 8, max = 64)
    private String email;

    @NotNull
    @Size(min = 2, max = 32)
    private String username;

    @NotNull
    @Min(1)
    private Integer age;

    @NotNull
    private UserType userType;

    @NotNull
    @Size(min = 8, max = 32)
    private String password;
}
