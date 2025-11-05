package com.localcode.vesty.user.auth.dto;

import com.localcode.vesty.shared.annotation.CPF;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SignupRequest {
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String name;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    @Size(max = 100)
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, max = 40, message = "Senha deve ter entre 6 e 40 caracteres")
    private String password;

    @NotBlank(message = "Data de nascimento é obrigatória")
    private LocalDate birthDate;

    @CPF
    @NotBlank(message = "Data de nascimento é obrigatório")
    private String cpf;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(
            regexp = "^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$",
            message = "Número de celular inválido. Use o formato (11) 91234-5678 ou 11912345678."
    )
    private String phone;
}
