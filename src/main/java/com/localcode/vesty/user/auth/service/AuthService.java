package com.localcode.vesty.user.auth.service;

import com.localcode.vesty.user.auth.UserEntity;
import com.localcode.vesty.user.auth.dto.SignupRequest;

import java.util.Optional;

public interface AuthService {
    void createUser(SignupRequest signup);

    Optional<UserEntity> findByEmail(String email);
}
