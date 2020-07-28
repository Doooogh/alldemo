package com.example.jwtdemo.dao;

import com.example.jwtdemo.entity.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserDao {
    SysUser findByUsername(@Param("username")String username);
}
