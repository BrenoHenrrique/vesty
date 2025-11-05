package com.localcode.vesty.user.auth.service;

import com.localcode.vesty.shared.security.JwtUtils;
import com.localcode.vesty.user.auth.AuthRepository;
import com.localcode.vesty.user.auth.UserEntity;
import com.localcode.vesty.user.auth.dto.LoginRequest;
import com.localcode.vesty.user.auth.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtUtils jwtUtils;
    private final AuthRepository authRepository;
    private final AuthenticationManager authenticationManager;

    public LoginResponse login(LoginRequest login) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword())
        );

        String token = jwtUtils.generateJwtToken(auth);

        LoginResponse response = new LoginResponse();
        response.setEmail(login.getEmail());
        response.setName(auth.getName());
        response.setToken(token);

        return response;
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return authRepository.findByEmail(email);
    }
}
