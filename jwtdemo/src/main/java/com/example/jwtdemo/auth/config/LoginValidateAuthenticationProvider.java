package com.example.jwtdemo.auth.config;

import com.example.jwtdemo.auth.CustomizedUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/29 12:47
 * @Version 1.0
 **/
public class LoginValidateAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomizedUserDetailsService customizedUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = customizedUserDetailsService.loadUserByUsername(username);
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        //确保authentication能转成该类
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
