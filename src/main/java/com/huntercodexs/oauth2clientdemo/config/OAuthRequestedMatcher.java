package com.huntercodexs.oauth2clientdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class OAuthRequestedMatcher implements RequestMatcher {

    @Override
    public boolean matches(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");

        log.debug("7. public boolean matches(HttpServletRequest request) auth");
        log.debug("7.1 auth: " + auth);
        log.debug("7.2 request: " + request);

        return (auth != null) && auth.startsWith("Bearer");
    }
    
}
