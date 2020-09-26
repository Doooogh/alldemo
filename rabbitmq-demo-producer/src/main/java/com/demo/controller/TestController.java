package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/22 14:24
 * @Version 1.0
 **/
@RestController
@RequestMapping("/rabbitmq")
public class TestController {

    @GetMapping("/test1")
    public String test1(){
        return "testin";
    }
}
