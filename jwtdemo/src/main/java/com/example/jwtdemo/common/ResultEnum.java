package com.example.jwtdemo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/28 12:28
 * @Version 1.0
 **/
@Getter
@AllArgsConstructor
public enum  ResultEnum {
    SUCCESS(200,"success"),
    ERROR(500,"system error!"),
    ERROR1(501,"system error11!"),
    USER_NEED_AUTHORITIES(201,"用户未登录"),
    USER_LOGIN_FAILED(202,"用户账号或密码错误"),
    USER_LOGIN_SUCCESS(203,"用户登录成功"),
    USER_NO_ACCESS(204,"用户无权访问"),
    USER_LOGOUT_SUCCESS(205,"用户登出成功"),
    TOKEN_IS_BLACKLIST(206,"此token为黑名单"),
    LOGIN_IS_OVERDUE(207,"登录已失效"),
    ;

    private Integer code;
    private String message;
}
