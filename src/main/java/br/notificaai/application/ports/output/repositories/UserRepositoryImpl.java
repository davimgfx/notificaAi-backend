package br.notificaai.application.ports.output.repositories;

import java.util.Optional;

import br.notificaai.domain.entity.User;

public class UserRepositoryImpl implements UserRepository {

    public UserRepositoryImpl() {
    }

    public void createUser() {
    }

    @Override
    public User save(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<User> findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }
    
}
