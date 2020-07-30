package com.example.jwtdemo.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/30 11:08
 * @Version 1.0
 **/
@Data
public class SysPermission {
    private String id;
    private String parentId;
    private String name;
    private String type;
    private String path;
    private String permission;
    private Integer orderNum;
    private Integer disable;


}
