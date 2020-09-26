package com.example.jwtdemo.dao;

import com.example.jwtdemo.entity.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/30 11:15
 * @Version 1.0
 **/
public interface SysPermissionDao {

    List<SysPermission> getList();

    List<SysPermission> getListByIds(@Param("ids") List<String> ids);

    List<SysPermission>getListByRoleId(@Param("roleId") String roleId);
}
