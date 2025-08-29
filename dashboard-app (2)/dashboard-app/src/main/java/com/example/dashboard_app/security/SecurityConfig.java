package com.example.dashboard_app.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // disable CSRF for APIs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll()  // allow all requests to /api/*
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
