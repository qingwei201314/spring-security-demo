package com.kevin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;
import static org.springframework.security.config.Customizer.withDefaults;

@Service
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(form -> form.loginProcessingUrl("/login").loginPage("/static/login.html"))
                .httpBasic(withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/static/**").permitAll()
                        .requestMatchers("/addUser").hasAuthority("ROLE_admin")
                        .anyRequest().authenticated());
        return http.build();
    }

}

