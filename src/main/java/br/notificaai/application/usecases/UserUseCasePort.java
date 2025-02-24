package br.notificaai.application.usecases;


import br.notificaai.application.ports.input.request.UserRequestDTO;
import br.notificaai.domain.entity.User;

public interface UserUseCasePort {

    public User createUser(UserRequestDTO data);
}
