package br.notificaai.application.adapters.controller;

import br.notificaai.application.ports.output.repository.token.TokenJwtGeneratorPort;
import io.quarkus.security.UnauthorizedException;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/notification")
public class NotificationController {

    private final TokenJwtGeneratorPort tokenJwtGeneratorPort;
    private final SecurityContext securityContext;

    public NotificationController(TokenJwtGeneratorPort tokenJwtGeneratorPort, SecurityContext securityContext) {
        this.tokenJwtGeneratorPort = tokenJwtGeneratorPort;
        this.securityContext = securityContext;
    }

    @GET
    @Path("next_seven_days")
    @Transactional
    @RolesAllowed("User")
    public String getNextSevenDaysNotifications() {

        // Obtém o JsonWebToken do SecurityContext
        JsonWebToken jwtToken = (JsonWebToken) securityContext.getUserPrincipal();

        // Verifica se o token está expirado
        if (tokenJwtGeneratorPort.isJwtExpired(jwtToken)) {
            throw new UnauthorizedException("Token expirado.");
        }

        return "Funcionou";
    }
}
