package br.notificaai.application.ports.input.dto.user;

import jakarta.validation.constraints.*;

public class UserRequestRegisterDTO {


    @NotBlank(message="Campo nome não pode ser vazio")
    @Size(min = 3, max = 30, message = "Campo nome deve ter entre 3 e 30 caracteres")
    private String name;

    @Email
    @NotBlank(message="Campo email não pode ser vazio")
    @Size(min = 6, max = 30, message = "Campo email deve ter entre 6 e 30 caracteres")
    private String email;

    public UserRequestRegisterDTO(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

