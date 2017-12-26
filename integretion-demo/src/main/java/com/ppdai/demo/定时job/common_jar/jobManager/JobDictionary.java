package com.ppdai.demo.定时job.common_jar.jobManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by huanglijun on 2017/12/26.
 */
public class JobDictionary {
    private Map<String, JobBaseList> jobs = new ConcurrentHashMap();

    public JobDictionary() {
    }

    public void put(String key, JobBaseList value) {
        this.jobs.put(key, value);
    }

    public boolean contains(String key) {
        return this.jobs.containsKey(key);
    }

    public JobBaseList get(String key) {
        return (JobBaseList)this.jobs.get(key);
    }
}
