package com.localcode.vesty.user.auth.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LoginResponse {
    private String token;
    private Long id;
    private String name;
    private String email;
    private String type = "Bearer";
    private List<String> roles = new ArrayList<>();
}
