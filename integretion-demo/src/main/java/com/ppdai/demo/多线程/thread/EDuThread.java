package com.ppdai.demo.多线程.thread;

/**
 * Created by huanglijun on 2017/12/25.
 * 额度的多线程操作
 */
public class EDuThread extends Thread {

    /**
     * 需要快速执行的任务 (使用多线程去跑)
     */
    @Override
    public void run() {
        System.out.println("EDuThread run 执行了!!! " + Thread.currentThread().getName());
    }
}
