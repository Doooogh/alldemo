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

    //登录 权限 登出
    USER_IS_NOT_EXIST(10001,"用户不存在"),
    USER_LOGIN_FAILED(10002,"用户账号或密码错误"),
    USER_NEED_AUTHORITIES(10003,"用户未登录"),
    USER_IS_LOCKED(10004,"用户已被锁定"),
    USER_IS_DISABLED(10005,"用户已被禁用"),
    NOT_LOGIN_OR_TOKEN_OVERDUE(10006,"用户未登录或token已过期"),

    USER_LOGIN_SUCCESS(10007,"用户登录成功"),
    USER_NO_ACCESS(10008,"用户无权访问"),
    USER_LOGOUT_SUCCESS(10009,"用户登出成功"),
    TOKEN_IS_BLACKLIST(100010,"token获取失败"),
    ;

    private Integer code;
    private String message;
}
