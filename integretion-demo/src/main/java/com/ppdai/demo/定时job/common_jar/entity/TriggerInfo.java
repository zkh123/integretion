package com.ppdai.demo.定时job.common_jar.entity;

/**
 * Created by huanglijun on 2017/12/26.
 */
public class TriggerInfo {
    private String Id;
    private String Desc;

    public TriggerInfo() {
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getDesc() {
        return this.Desc;
    }

    public void setDesc(String desc) {
        this.Desc = desc;
    }
}
