package com.localcode.vesty.user.auth.service;

import com.localcode.vesty.user.auth.UserEntity;
import com.localcode.vesty.user.auth.dto.LoginRequest;
import com.localcode.vesty.user.auth.dto.LoginResponse;

import java.util.Optional;

public interface AuthService {
    LoginResponse login(LoginRequest login);

    Optional<UserEntity> findByEmail(String email);
}
