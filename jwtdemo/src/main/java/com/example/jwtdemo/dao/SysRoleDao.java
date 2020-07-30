package com.example.jwtdemo.dao;

import com.example.jwtdemo.entity.SysRole;

import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/30 10:54
 * @Version 1.0
 **/
public interface SysRoleDao {

    List<SysRole> getRoleByUserId(String userId);

}
