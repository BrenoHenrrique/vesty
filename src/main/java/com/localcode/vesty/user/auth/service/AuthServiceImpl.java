package com.localcode.vesty.user.auth.service;

import com.localcode.vesty.shared.exception.BusinessException;
import com.localcode.vesty.user.auth.UserEntity;
import com.localcode.vesty.user.auth.AuthRepository;
import com.localcode.vesty.user.auth.dto.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createUser(SignupRequest signup) {
        boolean emailExists = authRepository.findByEmail(signup.getEmail()).isPresent();
        if (emailExists) throw new BusinessException("Email já está em uso: " + signup.getEmail());

        UserEntity user = new UserEntity();
        user.setName(signup.getName());
        user.setEmail(signup.getEmail());
        user.setPassword(passwordEncoder.encode(signup.getPassword()));
        authRepository.save(user);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return authRepository.findByEmail(email);
    }
}
