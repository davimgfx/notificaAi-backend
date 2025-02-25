package br.notificaai;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {


    @ConfigProperty(name = "twitter.bearer.token")
    String bearerToken;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return bearerToken;
    }
}
