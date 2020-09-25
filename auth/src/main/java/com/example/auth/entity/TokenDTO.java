package com.example.auth.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author li long
 * @Description --Oauth2获取Token返回信息封装
 * @Date 2020/9/19 13:30
 * @Param
 * @return
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class TokenDTO {
    private String token;
    private String refreshToken;
    private String tokenHead;
    private int expiresIn;
}
