package com.localcode.vesty.user.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponse {
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 50, message = "Nome deve ter entre 2 e 50 caracteres")
    private String name;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    @Size(max = 100)
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, max = 40, message = "Senha deve ter entre 6 e 40 caracteres")
    private String password;
}
