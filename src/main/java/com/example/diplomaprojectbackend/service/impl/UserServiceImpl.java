package com.example.diplomaprojectbackend.service.impl;

import com.example.diplomaprojectbackend.controller.resource.LoginUserRequest;
import com.example.diplomaprojectbackend.controller.resource.RegisterUserRequest;
import com.example.diplomaprojectbackend.controller.resource.UserResponse;
import com.example.diplomaprojectbackend.entity.User;
import com.example.diplomaprojectbackend.repository.UserRepository;
import com.example.diplomaprojectbackend.service.UserService;
import com.example.diplomaprojectbackend.shared.exception.DuplicateEntityFieldException;
import com.example.diplomaprojectbackend.shared.exception.InvalidCredentialsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.diplomaprojectbackend.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserResponse register(RegisterUserRequest request) {
        try {
            User user = USER_MAPPER.fromRegisterUserRequest(request);
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            userRepository.save(user);

            return USER_MAPPER.toUserResponse(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEntityFieldException("Email already exists.");
        }
    }

    @Override
    public UserResponse login(LoginUserRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid email!"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid password!");
        } else {
            return USER_MAPPER.toUserResponse(user);
        }
    }

    @Override
    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Unable to find user with id " + id + "!");
        }
    }
}
