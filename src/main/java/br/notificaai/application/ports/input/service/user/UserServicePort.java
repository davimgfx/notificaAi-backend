package br.notificaai.application.ports.input.service.user;

import br.notificaai.application.ports.input.dto.user.UserRequestLoginDTO;
import br.notificaai.application.ports.input.dto.user.UserRequestRegisterDTO;
import br.notificaai.application.ports.input.response.UserResponseLoginDTO;

public interface UserServicePort {
     void createUser(UserRequestRegisterDTO user);
     Long generateAccessTokenUser(String userEmail);
     UserResponseLoginDTO regenerateAccessToken(String payload);
     UserResponseLoginDTO loginUser(UserRequestLoginDTO user);
}
