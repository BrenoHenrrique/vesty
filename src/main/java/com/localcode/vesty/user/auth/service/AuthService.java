package com.localcode.vesty.user.auth.service;

import com.localcode.vesty.user.auth.UserEntity;
import com.localcode.vesty.user.auth.dto.LoginRequest;
import com.localcode.vesty.user.auth.dto.LoginResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

public interface AuthService {
    LoginResponse login(LoginRequest login);

    Optional<UserEntity> findByEmail(String email);

    LoginResponse loginWithGoogle(@RequestBody Map<String, String> body);
}
