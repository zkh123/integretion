package com.ppdai.demo.单元测试.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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