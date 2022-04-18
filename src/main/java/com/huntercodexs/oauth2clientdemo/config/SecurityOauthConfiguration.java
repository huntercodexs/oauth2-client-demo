package com.huntercodexs.oauth2clientdemo.config;

import lombok.extern.slf4j.Slf4j;
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
public class SecurityOauthConfiguration extends ResourceServerConfigurerAdapter {

	@Value("${api.prefix:/huntercodexs/client/api}")
	private String apiPrefix;
	@Value("${oauth2.client-id}")
	private String username;
	@Value("${oauth2.client-secret}")
	private String password;
	@Value("${oauth2.url.check-token}")
	private String oauth2ServerCheckTokenUrl;
	
	@Bean
	public AccessTokenConverter accessTokenConverter() {

		DefaultAccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();

		log.debug("3. public AccessTokenConverter accessTokenConverter()");
		log.debug("3.1 tokenConverter: " + tokenConverter);

	    return tokenConverter;
	}

	@Bean
	public RemoteTokenServices remoteTokenServices() {

		RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		AccessTokenConverter accessTokenConverter = accessTokenConverter();
		String secret = new String(Base64.getDecoder().decode(password));

		remoteTokenServices.setCheckTokenEndpointUrl(oauth2ServerCheckTokenUrl);
		remoteTokenServices.setClientId(username);
		remoteTokenServices.setClientSecret(secret);
		remoteTokenServices.setAccessTokenConverter(accessTokenConverter);

		log.debug("4. public RemoteTokenServices remoteTokenServices() remoteTokenServices: ");
		log.debug("4.1 remoteTokenServices: " + remoteTokenServices);
		log.debug("4.2 accessTokenConverter: " + accessTokenConverter);

		return remoteTokenServices;

	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

		RemoteTokenServices remoteToken = remoteTokenServices();
		resources.tokenServices(remoteToken);

		log.debug("5. public void configure(ResourceServerSecurityConfigurer resources) resources: " + resources);
		log.debug(remoteToken.toString());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http/*.requestMatcher(new OAuthRequestedMatcher())*/.authorizeRequests()
				.antMatchers(apiPrefix+"/admin").authenticated()
				.antMatchers(apiPrefix+"/user").authenticated()
				.antMatchers(apiPrefix+"/others").permitAll().anyRequest().authenticated();

		log.debug("6. public void configure(HttpSecurity http) throws Exception");
	}

}
