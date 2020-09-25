package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/22 14:21
 * @Version 1.0
 **/

@SpringBootApplication()
public class RabbitMq {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMq.class,args);
    }
}
