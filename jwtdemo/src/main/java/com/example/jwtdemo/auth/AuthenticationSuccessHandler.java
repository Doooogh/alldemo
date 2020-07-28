package com.example.jwtdemo.auth;

import com.alibaba.fastjson.JSON;
import com.example.jwtdemo.common.CommonResult;
import com.example.jwtdemo.common.ResultEnum;
import com.example.jwtdemo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/28 22:55
 * @Version 1.0
 **/
public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        JwtUser userDetails = (JwtUser) authentication.getPrincipal();

        String jwtToken = jwtUtils.getToken(userDetails.getUsername());

        httpServletResponse.getWriter().write(JSON.toJSONString(CommonResult.successOfRestltEnum(ResultEnum.USER_LOGIN_SUCCESS,jwtToken)));
    }
}
