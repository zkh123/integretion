package com.ppdai.demo.定时job.common_jar.entity;

/**
 * Created by huanglijun on 2017/12/26.
 */
public class CronTriggerInfo extends TriggerInfo{
    private String Expression;

    public CronTriggerInfo() {
    }

    public String getExpression() {
        return this.Expression;
    }

    public void setExpression(String expression) {
        this.Expression = expression;
    }
}
