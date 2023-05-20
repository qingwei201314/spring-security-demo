package com.kevin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

@SpringBootApplication
@MapperScan("com.kevin.mapper")
@EnableMethodSecurity
public class Oauth2ServerApplication {
    public static void main(String[] args) {
        Argon2PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        String result = encoder.encode("password");
        System.out.println(result);
        String encode = "{argon2}$argon2id$v=19$m=16384,t=2,p=1$BHED+KE00u3UbrlebDLdwg$9v9TRYgvHZvp//55tIZUn8x90ggEZqX040LcIvu4944";
        System.out.println(encoder.matches("password", encode));
        SpringApplication.run(Oauth2ServerApplication.class, args);
    }
}
