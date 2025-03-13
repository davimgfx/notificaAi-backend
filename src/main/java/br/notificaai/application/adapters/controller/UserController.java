package br.notificaai.application.adapters.controller;

import br.notificaai.application.ports.input.dto.user.UserRequestRegisterDTO;
import br.notificaai.application.ports.input.dto.user.UserRequestTokenDTO;
import br.notificaai.application.ports.input.service.user.UserServicePort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/auth")
public class UserController {

    private final UserServicePort userServicePort;

    public UserController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @POST
    @Path("/register")
    @Transactional
    public void createUser(UserRequestRegisterDTO userDTO) {
        userServicePort.createUser(userDTO);
    }

    @POST
    @Path("login/token")
    @Transactional
    public void generateAccessTokenUser(UserRequestTokenDTO userDTO) {
        userServicePort.generateAccessTokenUser(userDTO.getEmail());
    }

//    @POST
//    @Path("login")
//    @Transactional
//    public void loginUser(UserRequestLoginDTO userDTO) {
//        userServicePort.createUser(userDTO);
//    }
}
