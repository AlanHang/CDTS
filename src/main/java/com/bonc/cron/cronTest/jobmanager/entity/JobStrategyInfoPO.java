package com.bonc.cron.cronTest.jobmanager.entity;

/**
 * @author ZhengHang
 * @create 2021-06-09 14:32
 */
public class JobStrategyInfoPO {
    private Integer jobId;
    //对应StrategyKey枚举类中的name值
    private String jobStrategyKey;
    private String jobStrategyValue;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
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

    public JobStrategyInfoPO(Integer jobId, String jobStrategyKey, String jobStrategyValue) {
        this.jobId = jobId;
        this.jobStrategyKey = jobStrategyKey;
        this.jobStrategyValue = jobStrategyValue;
    }

    public JobStrategyInfoPO() {
    }

    @Override
    public String toString() {
        return "JobStrategyInfoPO{" +
                "jobId=" + jobId +
                ", jobStrategyKey='" + jobStrategyKey + '\'' +
                ", jobStrategyValue='" + jobStrategyValue + '\'' +
                '}';
    }
}
