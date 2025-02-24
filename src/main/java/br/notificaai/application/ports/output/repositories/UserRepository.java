package br.notificaai.application.ports.output.repositories;

import java.util.Optional;

import br.notificaai.domain.entity.User;

public interface  UserRepository {
    User save(User user);
    Optional<User> findByEmail(String email);
}
