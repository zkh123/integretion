package com.ppdai.demo.多线程.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by huanglijun on 2017/12/25.
 */
public class EDuPool {
    private static EDuPool eDuPool;

    private ExecutorService service = null;

    /**
     * 获取线程池的实例
     * @return
     */
    public static EDuPool getSingleInstance(){
        if (null == eDuPool){
            eDuPool = new EDuPool();
        }
        return eDuPool;
    }

    /**
     * 无参构造函数
     */
    public EDuPool() {
        service = Executors.newFixedThreadPool(5);  //用5个线程去跑这个任务
    }

    /**
     * 执行传递进来的线程实例
     * @param thread
     */
    public void excute(Thread thread){
        service.execute(thread);
    }
}
