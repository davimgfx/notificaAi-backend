package br.notificaai.application.adapters.controller;

import br.notificaai.application.adapters.utils.HttpResponse;
import br.notificaai.application.ports.input.dto.user.UserRequestRegisterDTO;
import br.notificaai.application.ports.input.dto.user.UserRequestTokenDTO;
import br.notificaai.application.ports.input.service.user.UserServicePort;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;


import java.util.Set;

@Path("/auth")
public class UserController {

    private final UserServicePort userServicePort;

    @Inject
    Validator validator;

    public UserController(UserServicePort userServicePort) {

        this.userServicePort = userServicePort;
    }

    @POST
    @Path("/register")
    @Transactional
    public Response createUser(UserRequestRegisterDTO userDTO)  {
        Set<ConstraintViolation<UserRequestRegisterDTO>> violations = validator.validate(userDTO);

        if (violations.isEmpty()) {
            userServicePort.createUser(userDTO);
            return Response.status(Response.Status.CREATED)
                    .entity(new HttpResponse("Usuário criado com sucesso"))
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new HttpResponse(violations))
                    .build();
        }

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
