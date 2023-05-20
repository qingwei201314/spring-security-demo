package com.kevin.service;

import com.kevin.entity.User;
import com.kevin.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public Integer addUser(String name, String password) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String passwordEncoding = passwordEncoder.encode(password);
        User user = new User();
        user.setUsername(name);
        user.setPassword(passwordEncoding);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        return userMapper.insert(user);
    }

}
