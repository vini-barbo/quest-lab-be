package br.dev.viniciusbarbosa.questlab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeHttpRequests().anyRequest().permitAll();
        // http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

        return http.build();
    }
}
