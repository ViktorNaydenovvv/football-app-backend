package com.example.diplomaprojectbackend.controller;

import com.example.diplomaprojectbackend.controller.resource.LoginUserRequest;
import com.example.diplomaprojectbackend.controller.resource.RegisterUserRequest;
import com.example.diplomaprojectbackend.controller.resource.UserResponse;
import com.example.diplomaprojectbackend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterUserRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    private ResponseEntity<UserResponse> loginUser(@Valid @RequestBody LoginUserRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @DeleteMapping("delete/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
