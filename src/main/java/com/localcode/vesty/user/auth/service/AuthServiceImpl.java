package com.localcode.vesty.user.auth.service;

import com.localcode.vesty.shared.exception.BusinessException;
import com.localcode.vesty.shared.security.TokenProvider;
import com.localcode.vesty.user.auth.AuthRepository;
import com.localcode.vesty.user.auth.UserEntity;
import com.localcode.vesty.user.auth.dto.LoginRequest;
import com.localcode.vesty.user.auth.dto.LoginResponse;
import com.localcode.vesty.user.auth.dto.SignupRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final TokenProvider tokenProvider;
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public LoginResponse login(LoginRequest login) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword())
        );

        String token = tokenProvider.generateJwtToken(auth);
        UserEntity user = authRepository.findByEmail(login.getEmail()).orElseThrow(EntityNotFoundException::new);

        LoginResponse response = new LoginResponse();
        response.setEmail(login.getEmail());
        response.setName(user.getName());
        response.setToken(token);

        return response;
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return authRepository.findByEmail(email);
    }

    @Override
    public LoginResponse loginWithGoogle(@RequestBody Map<String, String> body) {
        return null;
    }

    @Override
    public void createUser(SignupRequest signup) {
        boolean emailExists = authRepository.existsByEmail(signup.getEmail());
        if (emailExists) {
            throw new BusinessException("Email já está em uso: " + signup.getEmail());
        }

        UserEntity user = new UserEntity();
        user.setName(signup.getName());
        user.setEmail(signup.getEmail());
        user.setPassword(passwordEncoder.encode(signup.getPassword()));
        authRepository.save(user);
    }
}
