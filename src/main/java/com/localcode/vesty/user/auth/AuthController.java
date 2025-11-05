package com.localcode.vesty.user.auth;

import com.localcode.vesty.user.auth.dto.SignupRequest;
import com.localcode.vesty.user.auth.service.AuthService;
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
    private final AuthService authService;

    @PostMapping("/login")
    public User authenticate(@RequestBody User user) {
        return null;
    }

    @PostMapping("/users/signup")
    public void create(@RequestBody SignupRequest signup) {
        authService.createUser(signup);
    }
}
