package br.notificaai.application.adapters.controller;

import br.notificaai.application.adapters.utils.HttpResponse;
import br.notificaai.application.ports.input.dto.user.UserRequestLoginDTO;
import br.notificaai.application.ports.input.dto.user.UserRequestRefreshTokenDTO;
import br.notificaai.application.ports.input.dto.user.UserRequestRegisterDTO;
import br.notificaai.application.ports.input.dto.user.UserRequestTokenDTO;
import br.notificaai.application.ports.input.response.UserResponseTokenDTO;
import br.notificaai.application.ports.input.service.user.UserServicePort;


import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.auth.principal.ParseException;
import org.eclipse.microprofile.jwt.JsonWebToken;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jose4j.json.internal.json_simple.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Optional;
import java.util.Set;

@Path("/auth")
public class UserController {

    @Inject
    Validator validator;

    @Inject
    JWTParser parser;

    private final UserServicePort userServicePort;

    public UserController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;

    }

    @POST
    @Path("/register")
    @Transactional
    public Response createUser(UserRequestRegisterDTO userDTO)  {
        Set<ConstraintViolation<UserRequestRegisterDTO>> violations = validator.validate(userDTO);

        if (violations.isEmpty()) {
            userServicePort.createUser(userDTO);
            return Response.status(Response.Status.CREATED)
                    .entity(new HttpResponse<>("Usuário criado com sucesso"))
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new HttpResponse<>(violations))
                    .build();
        }

    }

    @POST
    @Path("login/token")
    @Transactional
    public Response generateAccessTokenUser(UserRequestTokenDTO userDTO) {
        Set<ConstraintViolation<UserRequestTokenDTO>> violations = validator.validate(userDTO);
        if (violations.isEmpty()) {
            var sixDigitsToken = userServicePort.generateAccessTokenUser(userDTO.getEmail());
            return Response.status(Response.Status.CREATED)
                    .entity(new HttpResponse<>(new UserResponseTokenDTO(sixDigitsToken.toString())))
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new HttpResponse<>(violations))
                    .build();
        }
    }

    @POST
    @Path("login")
    @Transactional
    public Response loginUser(UserRequestLoginDTO userDTO) {
        Set<ConstraintViolation<UserRequestLoginDTO>> violations = validator.validate(userDTO);

        if (violations.isEmpty()) {
            var refreshAndAccessTokens = userServicePort.loginUser(userDTO);
            return Response.status(Response.Status.CREATED)
                    .entity(new HttpResponse<>(refreshAndAccessTokens))
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new HttpResponse<>(violations))
                    .build();
        }
    }

    @POST
    @Path("refresh-token")
    @Transactional
    public Response refreshToken(UserRequestRefreshTokenDTO refreshToken) throws Exception {
        Set<ConstraintViolation<UserRequestRefreshTokenDTO>> violations = validator.validate(refreshToken);


        String token = refreshToken.getRefreshToken();
        String[] parts = token.split("\\."); // Divide o token em 3 partes

        String payload = new String(Base64.getUrlDecoder().decode(parts[1]));

        System.out.println("payload: " + payload);


        if (violations.isEmpty()) {
            return Response.status(Response.Status.CREATED)
                    .entity(new HttpResponse<>("Foi"))
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new HttpResponse<>(violations))
                    .build();
        }
    }

}
