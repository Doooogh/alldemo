package com.example.jwtdemo.service;

import com.example.jwtdemo.entity.SysUser;

public interface SysUserService {
    SysUser findByUsername(String username);

    String login(String username,String password);
}
