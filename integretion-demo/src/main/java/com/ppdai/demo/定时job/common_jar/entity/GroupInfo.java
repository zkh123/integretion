package com.ppdai.demo.定时job.common_jar.entity;

/**
 * Created by huanglijun on 2017/12/26.
 */
public class GroupInfo {
    private String Flag;
    private String JobClass;
    private int Prority;

    public GroupInfo() {
    }

    public String getFlag() {
        return this.Flag;
    }

    public void setFlag(String flag) {
        this.Flag = flag;
    }

    public String getJobClass() {
        return this.JobClass;
    }

    public void setJobClass(String jobClass) {
        this.JobClass = jobClass;
    }

    public int getPrority() {
        return this.Prority;
    }

    public void setPrority(int prority) {
        this.Prority = prority;
    }
}
