package com.kevin.controller;

import com.kevin.entity.User;
import com.kevin.mapper.UserMapper;
import com.kevin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Permission;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    List<User> home() {
        List<User> userList = userMapper.selectList(null);
        return userList;
    }

    @RequestMapping("/login")
    String login() {
        return "login controller";
    }

    @RequestMapping("/api")
    String api() {
        return "api";
    }

    @RequestMapping("/form")
    @PreAuthorize("hasAuthority('user:read')")
    String form(String name, String age) {
        return name + age;
    }

    /**
     * 添加用户
     */
    @PostMapping("/addUser")
    Integer addUser(String name, String password) {
        return userService.addUser(name, password);
    }
}
