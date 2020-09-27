package com.example.authdemo.service;

import com.example.authdemo.entity.CusUserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/27 16:58
 * @Version 1.0
 **/
//@Service
public class CusUserServiceDetailImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        CusUserDetail cusUserDetail=new CusUserDetail();
        cusUserDetail.setUsername("test");
        cusUserDetail.setPassword(new BCryptPasswordEncoder().encode("test"));
        return cusUserDetail;
    }
}
