package com.ppdai.demo.定时job.common_jar.jobManager;

import com.ppdai.demo.定时job.common_jar.JobBase;
import com.ppdai.demo.定时job.common_jar.entity.JobMsgEntity;

import javax.servlet.ServletException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by huanglijun on 2017/12/26.
 */
public class JobManager {
    private JobDictionary jobs = new JobDictionary();
    private static JobManager self = null;

    public JobManager() {
    }

    public static JobManager getInstance() {
        if(self == null) {
            Class var0 = JobManager.class;
            synchronized(JobManager.class) {
                if(self == null) {
                    self = new JobManager();
                }
            }
        }

        return self;
    }

    public synchronized void runJob(JobMsgEntity jme, boolean needParallel) throws ServletException {
        String className = jme.getJobClassFullName();
        String param = jme.getParam();
        if(this.jobs.contains(className)) {
            if(!this.jobs.get(className).canRun(jme, needParallel, className)) {
                return;
            }

            this.jobs.get(className).removeStoped(jme);
        }

        try {
            this.addJobAndRun(className, param, 0);
        } catch (Exception var6) {
            throw new ServletException(var6);
        }

        jme.setJobInfo("开始运行新实例!");
    }

    private void addJobAndRun(String jobClass, String param, int configId) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        JobBase job = this.createJob(jobClass);
        job.setConfigId(configId);
        job.run(param);
        if(!this.jobs.contains(jobClass)) {
            this.jobs.put(jobClass, new JobBaseList());
        }

        this.jobs.get(jobClass).Insert(0, job);
    }

    private JobBase createJob(String jobClass) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass(jobClass);
        Constructor cons = clazz.getDeclaredConstructor((Class[])null);
        JobBase job = (JobBase)cons.newInstance(new Object[0]);
        return job;
    }
}
