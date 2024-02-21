package com.example.diplomaprojectbackend.service.impl;

import com.example.diplomaprojectbackend.repository.UserRepository;
import com.example.diplomaprojectbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    @Override
//    public UserResponse login(LoginUserRequest loginRequest) {
//        User user = userRepository.findByEmail(loginRequest.getEmail())
//                .orElseThrow(() -> new InvalidCredentialsException("Invalid email!"));
//
//        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//            throw new InvalidCredentialsException("Invalid password!");
//        } else {
//            return USER_MAPPER.toUserResponse(user);
//        }
//    }
}