package com.example.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/24 14:49
 * @Version 1.0
 **/
@RestController
public class TestController {


    @GetMapping("/v2/api-docs")
    public String test(){
        return "test";
    }
}
