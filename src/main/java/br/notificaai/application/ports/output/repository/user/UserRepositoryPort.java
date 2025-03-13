package br.notificaai.application.ports.output.repository.user;

import br.notificaai.domain.User;

public interface UserRepositoryPort {

    void saveUser(User user);
    Long saveAccessToken(String userEmail, Long accessToken);
}
