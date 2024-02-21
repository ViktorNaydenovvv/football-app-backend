package com.example.diplomaprojectbackend.controller.resource;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignInRequest {
    @NotEmpty
    @Size(min = 8, max = 64)
    private String email;

    @NotEmpty
    @Size(min = 8, max = 32)
    private String password;
}
