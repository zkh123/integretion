package com.ppdai.demo.定时job.my_do;

import com.ppdai.demo.定时job.common_jar.JobBase;

import java.io.FileNotFoundException;

/**
 * Created by huanglijun on 2017/12/26.
 */
public class SecondJob extends JobBase {
    @Override
    protected void onStart(String var1) throws FileNotFoundException {
        System.out.println("SecondJob do");
    }
}
