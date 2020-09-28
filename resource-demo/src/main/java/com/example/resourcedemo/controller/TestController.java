package com.example.resourcedemo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/28 10:50
 * @Version 1.0
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    public static void main(String[] args) {
        String publicKey = null;
        ClassPathResource classPathResource = new ClassPathResource("public.txt");
        try {
            InputStream inputStream =classPathResource.getInputStream();
            publicKey = inputStream2String(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(publicKey);

    }

    private static String inputStream2String(InputStream inputStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null){
            buffer.append(line);
        }
        return buffer.toString();
    }




}
