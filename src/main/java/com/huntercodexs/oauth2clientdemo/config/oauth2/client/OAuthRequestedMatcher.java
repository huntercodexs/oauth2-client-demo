package com.huntercodexs.oauth2clientdemo.config.oauth2.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class OAuthRequestedMatcher implements RequestMatcher {

    @Override
    public boolean matches(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        return (auth != null) && auth.startsWith("Bearer");
    }
    
}
