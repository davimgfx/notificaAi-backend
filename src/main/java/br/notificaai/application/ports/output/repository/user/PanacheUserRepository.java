package br.notificaai.application.ports.output.repository.user;

import br.notificaai.application.ports.output.entity.user.PanacheUserEntity;
import br.notificaai.domain.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceException;

import java.nio.file.FileSystemNotFoundException;
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

        try{
            persist(entity);
        } catch(PersistenceException e){
            throw new IllegalArgumentException("Já existe um usuário com o e-mail fornecido.");
        }
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

    @Override
    public User getUserByEmail(String email) {
        PanacheUserEntity entity = find("email", email).firstResult();
        if (entity == null) {
            throw new FileSystemNotFoundException("O usuario não foi encontrado.");
        }

        var user = new User(entity.id, entity.name, entity.email, entity.loginToken, entity.loginTokenExpiration, entity.createdAt, entity.updatedAt);


        return user;

    }
}
