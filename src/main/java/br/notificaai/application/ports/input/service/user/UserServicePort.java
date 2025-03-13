package br.notificaai.application.ports.input.service.user;

import br.notificaai.application.ports.input.dto.user.UserRequestLoginDTO;
import br.notificaai.application.ports.input.dto.user.UserRequestRegisterDTO;

public interface UserServicePort {
     void createUser(UserRequestRegisterDTO user);
     Long generateAccessTokenUser(String userEmail);

     void loginUser(UserRequestLoginDTO user);
}
