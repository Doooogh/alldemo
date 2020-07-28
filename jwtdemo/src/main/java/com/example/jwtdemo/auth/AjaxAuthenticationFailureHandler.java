package com.example.jwtdemo.auth;

import com.alibaba.fastjson.JSON;
import com.example.jwtdemo.common.CommonResult;
import com.example.jwtdemo.common.ResultEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description  用户登录失败时返回给前端的数据
 * @Author li long
 * @Date 2020/7/28 22:54
 * @Version 1.0
 **/
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(JSON.toJSONString(CommonResult.errorOfRestltEnum(ResultEnum.USER_LOGIN_FAILED)));
        response.getWriter().flush();
    }
}
