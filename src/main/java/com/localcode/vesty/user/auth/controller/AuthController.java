package com.localcode.vesty.user.auth.controller;

import com.localcode.vesty.user.auth.dto.UserRequest;
import com.localcode.vesty.user.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public User authenticate(@RequestBody User user) {
        return null;
    }

    @PostMapping("/users")
    public User create(@RequestBody UserRequest user) {
        return null;
    }
}
