package com.ppdai.demo.单元测试.service;

import org.springframework.stereotype.Service;

/**
 * Created by huanglijun on 2017/12/15.
 */
@Service
public class HelloService {

    public String hello(String param){
        String temp;
        if ("ppdai".equalsIgnoreCase(param)){
            temp = "您请求参数为: " + param;
        }else {
            temp = "error";
        }
        return temp;
    }
}
