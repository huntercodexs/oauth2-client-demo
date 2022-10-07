package com.huntercodexs.oauth2clientdemo.config.oauth2.client;

import com.huntercodexs.oauth2clientdemo.config.oauth2.model.Oauth2ClientEntity;
import com.huntercodexs.oauth2clientdemo.config.oauth2.repository.Oauth2ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

import java.util.Base64;

@Slf4j
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class Oauth2Client extends ResourceServerConfigurerAdapter {

	@Value("${huntercodexs.basic-auth.credentials}")
	String sourceCredentials;

	@Value("${api.prefix:/huntercodexs/client/api}")
	private String apiPrefix;

	@Value("${oauth2.client-id}")
	private String username;

	@Value("${oauth2.client-secret}")
	private String password;

	@Value("${oauth2.url.check-token}")
	private String oauth2ServerCheckTokenUrl;

	@Autowired
	private Oauth2ClientRepository oauth2ClientRepository;
	
	@Bean
	public AccessTokenConverter accessTokenConverter() {
		DefaultAccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();
	    return tokenConverter;
	}

	@Bean
	public RemoteTokenServices remoteTokenServices() {
		if (sourceCredentials.equals("db")) {
			Oauth2ClientEntity credentials = oauth2ClientRepository.findCredentials();
			username = credentials.getClientId();
			password = credentials.getClientSecret();
			oauth2ServerCheckTokenUrl = credentials.getUrlCheckToken();
		}
		RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		AccessTokenConverter accessTokenConverter = accessTokenConverter();
		String secret = new String(Base64.getDecoder().decode(password));

		remoteTokenServices.setCheckTokenEndpointUrl(oauth2ServerCheckTokenUrl);
		remoteTokenServices.setClientId(username);
		remoteTokenServices.setClientSecret(secret);
		remoteTokenServices.setAccessTokenConverter(accessTokenConverter);

		return remoteTokenServices;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		RemoteTokenServices remoteToken = remoteTokenServices();
		resources.tokenServices(remoteToken);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http/*.requestMatcher(new OAuthRequestedMatcher())*/
				.authorizeRequests()
				/*Allowed Endpoints*/
				.antMatchers(apiPrefix+"/others").permitAll()
				/*Restrict Endpoints*/
				.antMatchers(apiPrefix+"/admin").authenticated()
				.antMatchers(apiPrefix+"/user").authenticated()
				/*Swagger*/
				.antMatchers("/swagger-ui/**").permitAll()
				.antMatchers("/api-docs/**").permitAll()
				.antMatchers("/api-docs.yaml").permitAll()
				/*Swagger (With Prefix)*/
				.antMatchers(apiPrefix+"/swagger-ui/**").permitAll()
				.antMatchers(apiPrefix+"/api-docs/**").permitAll()
				.antMatchers(apiPrefix+"/api-docs.yaml").permitAll()
				/*Actuator*/
				.antMatchers("/actuator/**").permitAll()
				.anyRequest().authenticated();
	}

}
