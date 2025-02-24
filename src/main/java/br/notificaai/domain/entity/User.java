package br.notificaai.domain.entity;

import java.time.LocalDateTime;

public class User {

    private Long id;
    private String name;
    private String email;
    private Long loginToken;
    private LocalDateTime loginTokenExpiration;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {
    }

    public User(Long id, String name, String email, Long loginToken, LocalDateTime loginTokenExpiration, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.loginToken = loginToken;
        this.loginTokenExpiration = loginTokenExpiration;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(Long loginToken) {
        this.loginToken = loginToken;
    }

    public LocalDateTime getLoginTokenExpiration() {
        return loginTokenExpiration;
    }

    public void setLoginTokenExpiration(LocalDateTime loginTokenExpiration) {
        this.loginTokenExpiration = loginTokenExpiration;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
