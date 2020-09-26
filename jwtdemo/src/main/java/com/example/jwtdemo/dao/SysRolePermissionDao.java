package com.example.jwtdemo.dao;

import com.example.jwtdemo.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/4 9:27
 * @Version 1.0
 **/
public interface SysRolePermissionDao {
    List<String> getPermissionIdsByRoleId(@Param("roleId") String roleId);
}
