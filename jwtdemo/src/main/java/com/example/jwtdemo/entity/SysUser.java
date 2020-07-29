package com.example.jwtdemo.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/28 19:31
 * @Version 1.0
 **/
@Data
public class SysUser {

    private String id;
    private String username;
    private String password;
    private Integer locked;
    private Integer disabled;
    private List<Role> roleList;
}
