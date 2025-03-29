package br.notificaai.application.ports.input.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestLoginDTO {

    @Email
    @NotBlank(message="Campo email não pode ser vazio")
    @Size(min = 6, max = 30, message = "Campo email deve ter entre 6 e 30 caracteres")
    private String email;
    
    @NotBlank(message="Campo token não pode ser vazio")
    @Size(min = 6, max = 6, message = "Campo email deve ter 6 caracteres")
    private String token;

    public UserRequestLoginDTO(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
