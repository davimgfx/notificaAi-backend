package br.notificaai.application.ports.input.controllers;

import br.notificaai.application.ports.input.usecases.TwitterUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/twitter")
public class TwitterController {

    @Inject
    TwitterUseCase twitterUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@QueryParam("username") String username) {
        String result = twitterUseCase.getUserByUsername(username);
        return Response.ok(result).build();
    }
}
