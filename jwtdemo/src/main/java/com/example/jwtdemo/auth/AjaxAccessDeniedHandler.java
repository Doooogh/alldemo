package com.example.jwtdemo.auth;

import com.alibaba.fastjson.JSON;
import com.example.jwtdemo.common.CommonResult;
import com.example.jwtdemo.common.ResultEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 无权访问
 * @Author li long
 * @Date 2020/7/28 22:50
 * @Version 1.0
 **/
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(JSON.toJSONString(CommonResult.errorOfRestltEnum(ResultEnum.USER_NO_ACCESS)));
        response.getWriter().flush();
    }
}
