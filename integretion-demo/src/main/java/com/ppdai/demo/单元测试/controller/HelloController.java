package com.ppdai.demo.单元测试.controller;

import com.ppdai.demo.单元测试.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huanglijun on 2017/12/15.
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hello")
    public Object hello(@RequestParam(value = "username")String username){
        Object result = helloService.hello(username);
        return result;
    }


    @GetMapping(value = "/no")
    public Object noParamter(){
        return "ok";
    }
}