package com.example.jwtdemo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/4 9:27
 * @Version 1.0
 **/
public interface SysRoleMenuDao {
    List<String> getMenuIdsByRoleId(@Param("roleId") String roleId);
}
