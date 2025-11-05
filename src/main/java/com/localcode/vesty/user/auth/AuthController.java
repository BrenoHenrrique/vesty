package com.localcode.vesty.user.auth;

import com.localcode.vesty.user.auth.dto.LoginRequest;
import com.localcode.vesty.user.auth.dto.LoginResponse;
import com.localcode.vesty.user.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class AuthController {
    private final AuthService service;

    @PostMapping("/login")
    public LoginResponse authenticate(@RequestBody LoginRequest login) {
        return service.login(login);
    }
}
