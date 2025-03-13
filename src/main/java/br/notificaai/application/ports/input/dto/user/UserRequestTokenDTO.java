package br.notificaai.application.ports.input.dto.user;

public class UserRequestTokenDTO {

    private String email;

    public UserRequestTokenDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
