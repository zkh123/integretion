package com.ppdai.demo.定时job.common_jar.entity;

/**
 * Created by huanglijun on 2017/12/26.
 */
public enum JobResult {
    Success(0, "Success"),
    Fail(1, "Fail"),
    Exception(2, "Exception"),
    Abort(3, "Abort");

    private final int code;
    private final String message;

    private JobResult(int code, String message) {
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

    public static int getCode(JobResult value) {
        return value == null?0:value.getCode();
    }
}
