package com.huntercodexs.oauth2clientdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.Base64;

@Slf4j
@Configuration
@EnableOAuth2Client
public class OAuth2Client {

    @Value("${oauth2.url.token}")
    String oauth2ServerToken;
    @Value("${oauth2.client-id}")
    String clientId;
    @Value("${oauth2.client-secret}")
    String clientSecret;
    @Value("${oauth2.grant-type:password}")
    String grantType;

    @Autowired
    private OAuth2ClientContext oauth2Context;

    @Bean
    public OAuth2RestTemplate restTemplate() {

        OAuth2ProtectedResourceDetails credentials = credentials();
        log.debug("2. public OAuth2RestTemplate restTemplate()");
        log.debug("2.1 Credentials-getClientId: " + credentials.getClientId());
        log.debug("2.2 Credentials-getClientSecret: " + credentials.getClientSecret());
        log.debug("2.3 Credentials-getAccessTokenUri: " + credentials.getAccessTokenUri());
        log.debug("2.4 Credentials-getGrantType: " + credentials.getGrantType());
        log.debug("2.5 Credentials-getTokenName: " + credentials.getTokenName());
        log.debug("2.6 Credentials-getScope: " + credentials.getScope());
        return new OAuth2RestTemplate(credentials, oauth2Context);
    }

    @Bean
    public OAuth2ProtectedResourceDetails credentials() {

        ClientCredentialsResourceDetails clientCredentials = new ClientCredentialsResourceDetails();
        clientCredentials.setAccessTokenUri(oauth2ServerToken);
        clientCredentials.setClientId(clientId);
        clientCredentials.setClientSecret(new String(Base64.getUrlDecoder().decode(clientSecret)));
        clientCredentials.setGrantType(grantType);

        log.debug("1. public OAuth2ProtectedResourceDetails credentials()");

        return clientCredentials;

    }

}

