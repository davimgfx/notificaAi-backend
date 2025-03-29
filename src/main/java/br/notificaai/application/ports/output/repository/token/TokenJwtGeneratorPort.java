package br.notificaai.application.ports.output.repository.token;

import br.notificaai.domain.User;
import org.eclipse.microprofile.jwt.JsonWebToken;

public interface TokenJwtGeneratorPort {
    String generateJwtToken(User user);
    String generateJwtRefreshToken(String email);
    Boolean isJwtExpired(JsonWebToken jwtToken);

}
