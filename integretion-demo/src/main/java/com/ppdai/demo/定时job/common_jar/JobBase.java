package com.ppdai.demo.定时job.common_jar;

import com.ppdai.demo.定时job.common_jar.entity.JobResult;
import com.ppdai.demo.定时job.common_jar.entity.JobStatus;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by huanglijun on 2017/12/26.
 */
public abstract class JobBase {
    protected int ConfigId;
    protected String Param;
    protected Date lastEndTime;
    protected Date StartTime;
    private JobResult jobResult;
    private JobStatus jobStatus;
    private Thread thd;

    public JobBase() {
    }

    public JobStatus getJobStatus() {
        return this.jobStatus;
    }

    public void setJobStatus(JobStatus value) {
        this.jobStatus = value;
        if(value == JobStatus.Stoped) {
            this.lastEndTime = Util.MinDate;
        }
    }

    public JobResult getJobResult() {
        return this.jobResult;
    }
    public void setJobResult(JobResult value) {
        this.jobResult = value;
    }
    public int getConfigId() {
        return this.ConfigId;
    }
    public void setConfigId(int value) {
        this.ConfigId = value;
    }
    public Date getStartTime() {
        return this.StartTime;
    }
    public Date getLastEndTime() {
        return this.lastEndTime;
    }
    protected String getJobInfo() {
        return this.getClass().getName();
    }
    protected void onAbort() {
        this.jobResult = JobResult.Abort;
    }
    protected void onException(Exception ex) {
        this.jobResult = JobResult.Exception;
    }

    protected abstract void onStart(String var1) throws FileNotFoundException;

    public void run(String param) {
        this.StartTime = new Date();
        this.Param = param;
        this.thd = new Thread(new Runnable() {
            public void run() {
                JobBase.this.start();
            }
        });
        this.thd.start();
    }

    private void start() {
        try {
            this.lastEndTime = Util.MinDate;
            this.jobStatus = JobStatus.Running;
            this.onStart(this.Param);
            return;
        } catch (Exception var5) {
            this.onException(var5);
        } finally {
            this.jobStatus = JobStatus.Stoped;
        }
    }

    private void stop() {
        this.jobStatus = JobStatus.Stopping;
        if(this.jobStatus != JobStatus.Stoped) {
            this.jobResult = JobResult.Abort;
            this.jobStatus = JobStatus.Stoped;
        }
    }
}
