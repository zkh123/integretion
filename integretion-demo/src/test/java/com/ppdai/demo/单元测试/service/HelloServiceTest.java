package com.ppdai.demo.单元测试.service;

import com.alibaba.fastjson.JSONObject;
import com.ppdai.demo.随机随还接入黄金眼.GoldEyeData;
import com.ppdai.demo.随机随还接入黄金眼.GoldEyeInfo;
import com.ppdai.demo.随机随还接入黄金眼.GoldEyeOuter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huanglijun on 2017/12/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void hello() throws Exception {
        String result = helloService.hello("ppdaii");
        Assert.assertEquals("error",result);
    }
}