package br.notificaai.application.ports.input.proxy;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/2/users/by/username")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "https://api.x.com")
public interface TwitterProxy {

    @GET
    @Path("/{username}")
    String getUserByUsername(@PathParam("username") String username, @HeaderParam("Authorization") String bearerToken);
}
