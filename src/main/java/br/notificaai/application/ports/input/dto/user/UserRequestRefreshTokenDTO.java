package br.notificaai.application.ports.input.dto.user;

import jakarta.validation.constraints.NotBlank;

public class UserRequestRefreshTokenDTO {

    @NotBlank(message="Campo refreshToken não pode ser vazio")
    private String refreshToken;

    public UserRequestRefreshTokenDTO(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
