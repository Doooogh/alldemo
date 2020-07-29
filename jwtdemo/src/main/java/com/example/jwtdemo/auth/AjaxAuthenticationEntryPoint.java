package com.example.jwtdemo.auth;

import com.alibaba.fastjson.JSON;
import com.example.jwtdemo.common.CommonResult;
import com.example.jwtdemo.common.ResultEnum;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 用户登录失败
 * @Author li long
 * @Date 2020/7/28 22:48
 * @Version 1.0
 **/
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        System.out.println(e instanceof BadCredentialsException);
        ResultEnum resultEnum=null;
        if(e instanceof DisabledException){
            resultEnum=ResultEnum.USER_IS_DISABLED;
        }else if(e instanceof LockedException){
            resultEnum=ResultEnum.USER_IS_LOCKED;
        }else if(e instanceof UsernameNotFoundException){
            resultEnum=ResultEnum.USER_IS_NOT_EXIST;
        }else if(e instanceof BadCredentialsException){
            resultEnum=ResultEnum.USER_LOGIN_FAILED;
        }else{
            resultEnum=ResultEnum.NOT_LOGIN_OR_TOKEN_OVERDUE;
        }
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(JSON.toJSONString(CommonResult.errorOfRestltEnum(resultEnum)));
        response.getWriter().flush();
    }
}
