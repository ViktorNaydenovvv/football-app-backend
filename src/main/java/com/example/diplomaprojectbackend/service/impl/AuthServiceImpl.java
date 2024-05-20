package com.example.diplomaprojectbackend.service.impl;

import com.example.diplomaprojectbackend.controller.resource.AuthResponse;
import com.example.diplomaprojectbackend.controller.resource.SignInReq;
import com.example.diplomaprojectbackend.entity.User;
import com.example.diplomaprojectbackend.repository.CoachRepository;
import com.example.diplomaprojectbackend.repository.FootballerRepository;
import com.example.diplomaprojectbackend.repository.UserRepository;
import com.example.diplomaprojectbackend.service.AuthService;
import com.example.diplomaprojectbackend.service.JwtService;
import com.example.diplomaprojectbackend.shared.UserType;
import com.example.diplomaprojectbackend.shared.exception.InvalidCredentialsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final FootballerRepository footballerRepository;
    private final CoachRepository coachRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
    private final JwtService jwtService;

    @Override
    public AuthResponse signIn(SignInReq signInData) {
        final User user = userRepository.findByEmail(signInData.getEmail());

        if (user == null) {
            throw new InvalidCredentialsException();
        }

        if (!passwordEncoder.matches(signInData.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        String token = jwtService.generateToken(user.getEmail());

        if (user.getUserType() == UserType.FOOTBALLER) {
            return new AuthResponse(footballerRepository.findByUserId(user.getId()), token);
        } else {
            return new AuthResponse(coachRepository.findByUserId(user.getId()), token);
        }
    }
}
