package com.scaffold.spring_boot.service;

import com.scaffold.spring_boot.dto.request.AuthenticationRequest;
import com.scaffold.spring_boot.dto.response.AuthenticationResponse;
import com.scaffold.spring_boot.entity.Users;
import com.scaffold.spring_boot.exception.AppException;
import com.scaffold.spring_boot.exception.ErrorCode;
import com.scaffold.spring_boot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest) {
        Users user = userRepository.findByUsername(authenticationRequest.getUsername());
        if (user == null) {
            throw new AppException(ErrorCode.AUTHENTICATION_FAILED);
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        if (!passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword())) {
            throw new AppException(ErrorCode.AUTHENTICATION_FAILED);
        }
        return AuthenticationResponse.builder()
                .success(true)
                .build();
    }
}
