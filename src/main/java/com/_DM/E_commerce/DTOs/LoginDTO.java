package com._DM.E_commerce.DTOs;

import com._DM.E_commerce.entity.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class LoginDTO {

    @NotBlank(message = "O campo não pode estar vazio.")
    @Email(message = "Digite um email válido")
    private String email;
    @NotBlank(message = "O campo não pode estar vazio.")
    private String senha;

    public LoginDTO(String email, String senha, Role roles) {
        this.email = email;
        this.senha = senha;
    }
}