package br.notificaai.application.ports.input.service.user;

import br.notificaai.application.ports.input.dto.user.UserRequestLoginDTO;
import br.notificaai.application.ports.input.dto.user.UserRequestRegisterDTO;
import br.notificaai.application.ports.input.response.UserResponseLoginDTO;
import br.notificaai.application.ports.input.response.UserResponseTokenDTO;
import br.notificaai.application.ports.output.repository.token.TokenJwtGeneratorImpl;
import br.notificaai.application.ports.output.repository.user.UserRepositoryPort;
import br.notificaai.domain.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Random;

@ApplicationScoped
public class UserServiceImpl implements UserServicePort {

    private final UserRepositoryPort userRepository;

    @Inject
    TokenJwtGeneratorImpl token;

    @Inject
    public UserServiceImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepository = userRepositoryPort;
    }


    @Override
    public void createUser(UserRequestRegisterDTO user) {
        User newUser = new User(user.getName(), user.getEmail());
        this.userRepository.saveUser(newUser);
    }

    @Override
    public Long generateAccessTokenUser(String userEmail) {
        Random random = new Random();

        Long randomToken6digits = 100000 + random.nextLong(900000);

        return this.userRepository.saveAccessToken(userEmail, randomToken6digits);
    }

    @Override
    public UserResponseLoginDTO loginUser(UserRequestLoginDTO user) {
        User userAccount = this.userRepository.getUserByEmail(user.getEmail());

        String jwtToken = token.generateJwtToken(userAccount);
        String refreshToken = token.generateJwtRefreshToken(user.getEmail());

        System.out.println(jwtToken);

        return new UserResponseLoginDTO(jwtToken, refreshToken);
    }

    @Override
    public Long validateAccessToken(String refreshToken) {




        return 1L;
    }
}
