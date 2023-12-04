package me.suongnguyen.microservice.config;

import org.springframework.security.oauth2.jwt.JwtDecoder;

public class SecurityConfig  {

    private JwtDecoder decoder() {
        return NimbusJwtDecoder.
    }

}
