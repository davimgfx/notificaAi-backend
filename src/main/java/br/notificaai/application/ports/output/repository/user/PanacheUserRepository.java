package br.notificaai.application.ports.output.repository.user;

import br.notificaai.application.ports.output.entity.user.PanacheUserEntity;
import br.notificaai.domain.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.Optional;

@ApplicationScoped
public class PanacheUserRepository implements UserRepositoryPort, PanacheRepository<PanacheUserEntity> {

    @Override
    public void saveUser(User user) {
        PanacheUserEntity entity = new PanacheUserEntity();
        entity.createdAt = LocalDateTime.now();
        entity.name = user.getName();
        entity.email = user.getEmail();

        persist(entity);
    }

    @Override
    public Long saveAccessToken(String userEmail, Long accessToken) {

        Optional<PanacheUserEntity> existingUser = find("email", userEmail).firstResultOptional();

        if (!existingUser.isPresent()) {
            throw new IllegalArgumentException("O e-mail não foi encontrado.");
        }

        PanacheUserEntity user = existingUser.get();


        user.loginToken = accessToken;

        persist(user);

        return accessToken;
    }
}
