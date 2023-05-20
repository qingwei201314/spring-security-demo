package com.kevin.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kevin.entity.User;
import com.kevin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();
        query.eq(User::getUsername, username);
        User user = userMapper.selectOne(query);
        GrantedAuthority authority = new GrantedAuthority(){
            @Override
            public String getAuthority() {
                return "user:read";
            }
        };
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        authorityList.add(authority);
        user.setAuthorities(authorityList);

        return user;
    }

}
