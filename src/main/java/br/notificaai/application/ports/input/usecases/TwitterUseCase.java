package br.notificaai.application.ports.input.usecases;

import br.notificaai.application.ports.input.proxy.TwitterProxy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class TwitterUseCase {

    @Inject
    @RestClient
    TwitterProxy twitterProxy;

    @ConfigProperty(name = "twitter.bearer.token")
    String BEARER_TOKEN;

    public String getUserByUsername(String username) {
        return twitterProxy.getUserByUsername(username, "Bearer "+BEARER_TOKEN);
    }
}
