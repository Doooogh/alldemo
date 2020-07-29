package com.example.jwtdemo.service.impl;

import com.example.jwtdemo.auth.CustomizedUserDetailsService;
import com.example.jwtdemo.common.ResultEnum;
import com.example.jwtdemo.dao.SysUserDao;
import com.example.jwtdemo.entity.SysUser;
import com.example.jwtdemo.service.SysUserService;
import com.example.jwtdemo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/28 20:00
 * @Version 1.0
 **/
@Service
public class SysUserServiceImpl  implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private CustomizedUserDetailsService customizedUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public SysUser findByUsername(String username) {
        return sysUserDao.findByUsername(username);
    }

    @Override
    public String login(String username, String password) {
        String token=null;
        UserDetails userDetails = customizedUserDetailsService.loadUserByUsername(username);

        if(null!=userDetails){
            //对比密码
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException(ResultEnum.USER_LOGIN_FAILED.getMessage());
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtUtils.getToken(username);
        }
        return token;
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode("123456");
        //$2a$10$xcuttGC1V97i3BYCxUFBUOE8.kbr2hEPCW9imUP7UtwGJR/jhCQaC
        System.out.println(encodePassword);
    }

}
