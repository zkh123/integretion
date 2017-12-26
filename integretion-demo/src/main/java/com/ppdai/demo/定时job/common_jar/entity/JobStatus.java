package com.ppdai.demo.定时job.common_jar.entity;

/**
 * Created by huanglijun on 2017/12/26.
 */
public enum JobStatus {
    Stop(0, "Stop"),
    Running(1, "Running"),
    Stopping(2, "Stopping"),
    Stoped(3, "Stoped");

    private final int code;
    private final String message;

    private JobStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return this.code + "(" + this.message + ")";
    }

    public static int getCode(JobStatus value) {
        return value == null?0:value.getCode();
    }
}
