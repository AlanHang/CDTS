package com.bonc.cron.cronTest.jobmanager.entity;

import java.util.Date;

/**
 * 接收从前端传入的Job信息
 * @author ZhengHang
 * @create 2021-06-10 15:55
 */
public class JobInputInfoVO {

    private String jobId;
    private String jobName;
    private String jobRemark;
    //标识job是否可用，0为可用，1为不可用
    private int jobIsDel;
    private Date jobCreateTime;
    //标识job运行的类型，0为单次job,1为周期性job
    private int jobType;
    //标识job的状态，0为关闭，1为开启
    private int jobStatus;
    //执行队列的名称
    private String jobQueueName;
    //子计划并行个数
    private String subPlanAmounts;
    //忽略失败
    private boolean ignoreFails;
    //是否采用安全模式
    private boolean isSafe;
    //增量迁移是否冻结集群
    private boolean isFreeze;
    //失败重试次数
    private int retryCount;
    //是否只运行失败任务，只对单次任务生效
    private boolean isRunFails;
    //job周期执行策略
    private CycleRules rules;

    public JobInputInfoVO(String jobId, String jobName, String jobRemark, int jobIsDel, Date jobCreateTime, int jobType,
                          int jobStatus, String jobQueueName, String subPlanAmounts, boolean ignoreFails, boolean isSafe,
                          boolean isFreeze, int retryCount, boolean isRunFails, CycleRules rules) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobRemark = jobRemark;
        this.jobIsDel = jobIsDel;
        this.jobCreateTime = jobCreateTime;
        this.jobType = jobType;
        this.jobStatus = jobStatus;
        this.jobQueueName = jobQueueName;
        this.subPlanAmounts = subPlanAmounts;
        this.ignoreFails = ignoreFails;
        this.isSafe = isSafe;
        this.isFreeze = isFreeze;
        this.retryCount = retryCount;
        this.isRunFails = isRunFails;
        this.rules = rules;
    }

    public JobInputInfoVO() {
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobRemark() {
        return jobRemark;
    }

    public void setJobRemark(String jobRemark) {
        this.jobRemark = jobRemark;
    }

    public int getJobIsDel() {
        return jobIsDel;
    }

    public void setJobIsDel(int jobIsDel) {
        this.jobIsDel = jobIsDel;
    }

    public Date getJobCreateTime() {
        return jobCreateTime;
    }

    public void setJobCreateTime(Date jobCreateTime) {
        this.jobCreateTime = jobCreateTime;
    }

    public int getJobType() {
        return jobType;
    }

    public void setJobType(int jobType) {
        this.jobType = jobType;
    }

    public int getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobQueueName() {
        return jobQueueName;
    }

    public void setJobQueueName(String jobQueueName) {
        this.jobQueueName = jobQueueName;
    }

    public String getSubPlanAmounts() {
        return subPlanAmounts;
    }

    public void setSubPlanAmounts(String subPlanAmounts) {
        this.subPlanAmounts = subPlanAmounts;
    }

    public boolean isIgnoreFails() {
        return ignoreFails;
    }

    public void setIgnoreFails(boolean ignoreFails) {
        this.ignoreFails = ignoreFails;
    }

    public boolean isSafe() {
        return isSafe;
    }

    public void setSafe(boolean safe) {
        isSafe = safe;
    }

    public boolean isFreeze() {
        return isFreeze;
    }

    public void setFreeze(boolean freeze) {
        isFreeze = freeze;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public boolean isRunFails() {
        return isRunFails;
    }

    public void setRunFails(boolean runFails) {
        isRunFails = runFails;
    }

    public CycleRules getRules() {
        return rules;
    }

    public void setRules(CycleRules rules) {
        this.rules = rules;
    }
}
