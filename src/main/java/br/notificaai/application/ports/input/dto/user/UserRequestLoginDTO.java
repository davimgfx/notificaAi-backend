package br.notificaai.application.ports.input.dto.user;

public class UserRequestLoginDTO {
    private String email;
    private int accessToken;

    public UserRequestLoginDTO(String email, int accessToken) {
        this.email = email;
        this.accessToken = accessToken;
    }

    public int getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(int accessToken) {
        this.accessToken = accessToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
