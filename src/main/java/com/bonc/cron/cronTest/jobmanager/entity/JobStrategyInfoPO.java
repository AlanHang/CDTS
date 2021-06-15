package com.bonc.cron.cronTest.jobmanager.entity;

/**
 * @author ZhengHang
 * @create 2021-06-09 14:32
 */
public class JobStrategyInfoPO {
    private String jobId;
    //对应StrategyKey枚举类中的name值
    private String jobStrategyKey;
    private String jobStrategyValue;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobStrategyKey() {
        return jobStrategyKey;
    }

    public void setJobStrategyKey(String jobStrategyKey) {
        this.jobStrategyKey = jobStrategyKey;
    }

    public String getJobStrategyValue() {
        return jobStrategyValue;
    }

    public void setJobStrategyValue(String jobStrategyValue) {
        this.jobStrategyValue = jobStrategyValue;
    }
}
