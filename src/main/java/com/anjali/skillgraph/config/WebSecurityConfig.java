package com.anjali.skillgraph.config;

import com.anjali.skillgraph.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ✅ disable CSRF for simplicity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/users/register",
                                          "/users/login",
                                          "/api/auth/**",
                                          "/users/skills"
                        ).permitAll() // ✅ allow login/register
                        .anyRequest().authenticated() // ❌ everything else blocked (for now)
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}



