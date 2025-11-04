package com.localcode.vesty.user.auth.service;

import com.localcode.vesty.user.auth.UserEntity;

import java.util.Optional;

public interface UserService {
    void createUser(String name, String email, String password);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findById(Long id);

    boolean checkPassword(String rawPassword, String encodedPassword);

    String encodePassword(String rawPassword);

    void updatePassword(Long userId, String newPassword);
}
