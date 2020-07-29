package com.example.jwtdemo.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/28 12:25
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class CommonResult <T>{
    private Integer code;
    private String message;
    private T data;



    private static <T> CommonResult getInstance(Integer code, String message, T data){
        return new CommonResult(code,message,data);
    }

    private static <T> CommonResult getErrorInstance(Integer code, String message){
        return  getInstance(code,message,null);
    }


    public static <T> CommonResult success(){
        return new CommonResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(),null);
    }

    public static <T> CommonResult success(T data){
        return new CommonResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(),data);
    }
    public static <T> CommonResult successOfRestltEnum(ResultEnum resultEnum,T data){
        return new CommonResult(resultEnum.getCode(), resultEnum.getMessage(),data);
    }

    public static <T> CommonResult error(){
        return getErrorInstance(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMessage());
    }

    public static <T> CommonResult errorOfRestltEnum(ResultEnum resultEnum){
        return getErrorInstance(resultEnum.getCode(),resultEnum.getMessage());
    }

    public static <T> CommonResult errorOfMessage(String message){
        return getErrorInstance(ResultEnum.ERROR.getCode(),message);
    }

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static void main(String[] args) {
        String successMsg="successMsg";
        CommonResult success = success(successMsg);
        CommonResult error = error();
        CommonResult errorOfMessage = errorOfMessage("errorOfMessage");
        System.out.println(success);
        System.out.println(error);
        System.out.println(errorOfMessage);
    }
}
