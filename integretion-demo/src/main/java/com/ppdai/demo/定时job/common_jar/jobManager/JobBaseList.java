package com.ppdai.demo.定时job.common_jar.jobManager;

import com.ppdai.demo.定时job.common_jar.JobBase;
import com.ppdai.demo.定时job.common_jar.entity.JobMsgEntity;
import com.ppdai.demo.定时job.common_jar.entity.JobStatus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by huanglijun on 2017/12/26.
 */
public class JobBaseList {
    private List<JobBase> jobs = new ArrayList();

    public JobBaseList() {
    }

    public boolean canRun(JobMsgEntity jme, boolean needParallel, String jobClass) {
        if(needParallel) {
            return true;
        } else {
            synchronized(this) {
                Iterator i$ = this.jobs.iterator();

                JobBase job;
                do {
                    if(!i$.hasNext()) {
                        return true;
                    }

                    job = (JobBase)i$.next();
                } while(job.getJobStatus() != JobStatus.Running && job.getJobStatus() != JobStatus.Stopping);

                jme.setJobInfo("有实例在运行，此次请求忽略！");
                return false;
            }
        }
    }

    public synchronized void removeStoped(JobMsgEntity jme) {
        for(int i = this.jobs.size() - 1; i >= 0; --i) {
            JobBase job = (JobBase)this.jobs.get(i);
            if(job.getJobStatus() == JobStatus.Stoped) {
                if(jme.getLastEndTime() == null || job.getLastEndTime().after(jme.getLastEndTime())) {
                    jme.setLastEndTime(job.getLastEndTime());
                    jme.setJobResult(job.getJobResult());
                }

                this.jobs.remove(i);
            }
        }

    }

    public synchronized void Insert(int p, JobBase job) {
        this.jobs.add(p, job);
    }
}
