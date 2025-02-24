package br.notificaai.application.ports.input.request;

public class UserRequestDTO {
    private String name;
    private String email;

    public UserRequestDTO(String name, String email){
        this.name = name;
        this.email = email;
    }
}

