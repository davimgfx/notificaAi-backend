package br.notificaai.application.ports.input.dto.user;

public class UserRequestRegisterDTO {
    private String name;
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

