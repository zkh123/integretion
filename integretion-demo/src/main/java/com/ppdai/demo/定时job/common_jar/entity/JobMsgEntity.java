package com.ppdai.demo.定时job.common_jar.entity;

import com.ppdai.demo.定时job.common_jar.Util;

import java.util.Date;


/**
 * Created by huanglijun on 2017/12/26.
 */
public class JobMsgEntity {
    private String Action;
    private String HostIp;
    private String JobClassFullName;
    private String JobInfo;
    private JobResult JobResult;
    private JobStatus JobStatus;
    private Date LastEndTime;
    private Boolean NeedParallel;
    private String Param;

    public JobMsgEntity() {
    }

    public String getAction() {
        return this.Action;
    }

    public void setAction(String action) {
        this.Action = action;
    }

    public String getHostIp() {
        return this.HostIp;
    }

    public void setHostIp(String hostIp) {
        this.HostIp = hostIp;
    }

    public String getJobClassFullName() {
        return this.JobClassFullName;
    }

    public void setJobClassFullName(String jobClassFullName) {
        this.JobClassFullName = jobClassFullName;
    }

    public String getJobInfo() {
        return this.JobInfo;
    }

    public void setJobInfo(String jobInfo) {
        this.JobInfo = jobInfo;
    }

    public JobResult getJobResult() {
        return this.JobResult;
    }

    public void setJobResult(JobResult jobResult) {
        this.JobResult = jobResult;
    }

    public JobStatus getJobStatus() {
        return this.JobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.JobStatus = jobStatus;
    }

    public Date getLastEndTime() {
        return this.LastEndTime;
    }

    public void setLastEndTime(Date lastEndTime) {
        this.LastEndTime = lastEndTime;
    }

    public Boolean getNeedParallel() {
        return this.NeedParallel;
    }

    public void setNeedParallel(Boolean needParallel) {
        this.NeedParallel = needParallel;
    }

    public String getParam() {
        return this.Param;
    }

    public void setParam(String param) {
        this.Param = param;
    }

    public String toJson() {
        Object[] var10001 = new Object[]{Util.getStringForJson(this.getAction()), Util.getStringForJson(this.getHostIp()), Util.getStringForJson(this.getJobClassFullName()), Util.getStringForJson(this.getJobInfo()), null, null, null, null, null};
        JobResult var10004 = this.JobResult;
        var10001[4] = Integer.valueOf(JobResult.getCode(this.getJobResult()));
        JobStatus var2 = this.JobStatus;
        var10001[5] = Integer.valueOf(JobStatus.getCode(this.getJobStatus()));
        var10001[6] = Util.getUtcDateJsonWithTime((Date)null);
        var10001[7] = this.getNeedParallel();
        var10001[8] = Util.getStringForJson(this.getParam());
        String json = String.format("{\"Action\":\"%s\",\"HostIp\":\"%s\",\"JobClassFullName\":\"%s\",\"JobInfo\":\"%s\",\"JobResult\":%d,\"JobStatus\":%d,\"LastEndTime\":\"\\/%s\\/\",\"NeedParallel\":%b,\"Param\":\"%s\"}", var10001);
        return json;
    }
}
