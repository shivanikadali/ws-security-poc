package com.imaginnovate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @SuppressWarnings("removal")
    @Bean
        public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
            http
                .authorizeExchange(exchange -> exchange.pathMatchers("/employees/**").authenticated()
                    .anyExchange().denyAll());
            http
                .oauth2ResourceServer(server -> server.jwt());
    
            return http.build();
        } 
    
}
