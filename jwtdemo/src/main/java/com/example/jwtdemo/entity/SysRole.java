package com.example.jwtdemo.entity;

import lombok.Data;

import java.util.Set;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/28 19:32
 * @Version 1.0
 **/
@Data
public class SysRole {

    private String id;
    private String roleName;
    private String roleEnglishName;
    private Integer userNum;
    private Integer disable;
    private String description;
    private Integer sort;
    private Set<SysMenu> menuList;
    private Set<SysPermission> permissionList;
}
