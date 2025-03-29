package br.notificaai.application.ports.output.repository.token;

import br.notificaai.domain.User;
import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;


import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;


@ApplicationScoped
public class TokenJwtGeneratorImpl implements TokenJwtGeneratorPort {

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    @Override
    public String generateJwtToken(User user) {
        String token =
                Jwt.issuer(issuer)
                        .expiresAt(Instant.now().plus(Duration.ofSeconds(3600)))
                        .upn(user.getEmail())
                        .claim("email", user.getEmail())
                        .claim("name", user.getName())
                        .claim("id", user.getId())
                        .groups(new HashSet<>(Arrays.asList("User")))
                        .sign();

        return token;
    }

    @Override
    public String generateJwtRefreshToken(String email) {
        String token =
                Jwt.issuer(issuer)
                        .expiresAt(Instant.now().plus(Duration.ofHours(24 * 7)))
                        .claim("email", email)
                        .sign();

        return token;
    }

    @Override
    public Boolean isJwtExpired(JsonWebToken jwtToken) {
        try {
            // Use o JsonWebToken que o Quarkus já fornece
            long expTime = jwtToken.getClaim("exp");

            // Verifica se o token expirou
            Instant expInstant = Instant.ofEpochSecond(expTime);
            Instant now = Instant.now();

            // Retorna true se o token expirou
            return expInstant.isBefore(now);
        } catch (Exception e) {
            // Se ocorrer um erro ao tentar acessar a claim 'exp', considera-se que o token é inválido
            return true;
        }
    }
}
