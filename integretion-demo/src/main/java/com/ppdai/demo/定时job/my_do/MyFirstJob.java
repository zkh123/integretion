package com.ppdai.demo.定时job.my_do;

import com.ppdai.demo.定时job.common_jar.JobBase;

import java.io.FileNotFoundException;

/**
 * Created by huanglijun on 2017/12/26.
 */
public class MyFirstJob extends JobBase {
    @Override
    protected void onStart(String var1) throws FileNotFoundException {
        System.out.println("MyFirstJob do start...");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyFirstJob do end...");
    }
}
