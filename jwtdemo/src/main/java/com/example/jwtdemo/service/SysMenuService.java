package com.example.jwtdemo.service;

import com.example.jwtdemo.entity.SysPermission;

import java.util.List;

public interface SysMenuService {

    List<SysPermission> getMenuByUserId(String userId);
}
