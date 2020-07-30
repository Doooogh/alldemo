package com.example.jwtdemo.controller;

import com.example.jwtdemo.common.CommonResult;
import com.example.jwtdemo.common.ResultEnum;
import com.example.jwtdemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/28 23:44
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin")
public class LoginController {


    @Autowired
    private SysUserService sysUserService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    //
    @PostMapping("/login")
    public CommonResult login(String username,String password){
        String token = sysUserService.login(username, password);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping(value = "/testNeed")
    public String testNeed() {
        return "testNeed";
    }
}
