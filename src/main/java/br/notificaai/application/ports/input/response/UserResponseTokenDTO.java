package br.notificaai.application.ports.input.response;

public class UserResponseTokenDTO {
    private String token;

    public UserResponseTokenDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
