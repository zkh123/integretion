package com.ppdai.demo.随机随还接入黄金眼;

/**
 * 请求的核心参数
 * Created by huanglijun on 2017/12/27.
 */
public class GoldEyeData {
    private String userId;  //用户id
    private int processFlag;  // 0: 拒绝; 1: 通过
    private int pcOrApp;  // 0: pc用户 ; 1: app用户
    private String timeStamp; //时间戳
    private int isUsed;  // 是否使用上次的结论(预发的结论{SJSHAuditResult表中}) 0: 不使用 ; 1: 使用
    private boolean isBatch; // 跑批[贷中](定时触发)/用户触发--->形成预审的结果 存表. 0: 用户触发 ; 1: 跑批
    private String orderId; //标记是预审还是终审

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public int getProcessFlag() {
        return processFlag;
    }
    public void setProcessFlag(int processFlag) {
        this.processFlag = processFlag;
    }
    public int getPcOrApp() {
        return pcOrApp;
    }
    public void setPcOrApp(int pcOrApp) {
        this.pcOrApp = pcOrApp;
    }
    public String getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    public int getIsUsed() {
        return isUsed;
    }
    public void setIsUsed(int isUsed) {
        this.isUsed = isUsed;
    }

    public boolean isBatch() {
        return isBatch;
    }

    public void setBatch(boolean batch) {
        isBatch = batch;
    }

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
