package br.notificaai.application.ports.input.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestTokenDTO {

    @Email
    @NotBlank(message="Campo email não pode ser vazio")
    @Size(min = 6, max = 30, message = "Campo email deve ter entre 6 e 30 caracteres")
    private String email;

    public UserRequestTokenDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        return email;
    }

}
