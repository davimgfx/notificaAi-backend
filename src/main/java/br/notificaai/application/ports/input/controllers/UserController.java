package br.notificaai.application.ports.input.controllers;

import br.notificaai.application.ports.input.request.UserRequestDTO;
import br.notificaai.application.usecases.UserUseCasePort;
import br.notificaai.domain.entity.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

//   private UserUseCasePort UserUseCasePort;
   
//   public UserController(UserUseCasePort userUseCasePort){
//           this.UserUseCasePort = userUseCasePort;
//   }

    @POST
    public User createUser(UserRequestDTO data) {
        return null;
    }
}
