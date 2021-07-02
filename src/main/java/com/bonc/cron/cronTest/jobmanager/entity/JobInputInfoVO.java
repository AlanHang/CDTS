package com.bonc.cron.cronTest.jobmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 接收从前端传入的Job信息
 * @author ZhengHang
 * @create 2021-06-10 15:55
 */
public class JobInputInfoVO {

    private int jobId;
    private String jobName;
    private String jobRemark;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date jobCreateTime;
    //标识job运行的类型，0为单次job,1为周期性job
    private int jobType;
    //执行队列的名称
    private String jobQueueName;
    //子计划并行个数
    private int subPlanAmounts;
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
    //计划的执行顺序
    private List<Integer> plansId;

    public JobInputInfoVO(int jobId, String jobName, String jobRemark, Date jobCreateTime, int jobType,
                          String jobQueueName, int subPlanAmounts, boolean ignoreFails, boolean isSafe,
                          boolean isFreeze, int retryCount, boolean isRunFails, CycleRules rules,List<Integer> plansId) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobRemark = jobRemark;
        this.jobCreateTime = jobCreateTime;
        this.jobType = jobType;
        this.jobQueueName = jobQueueName;
        this.subPlanAmounts = subPlanAmounts;
        this.ignoreFails = ignoreFails;
        this.isSafe = isSafe;
        this.isFreeze = isFreeze;
        this.retryCount = retryCount;
        this.isRunFails = isRunFails;
        this.rules = rules;
        this.plansId = plansId;
    }

    public JobInputInfoVO() {
    }

    public JobInputInfoVO(int jobId) {
        this.jobId = jobId;
        this.rules = new CycleRules();
        this.rules.startTime = new Date();
        this.jobCreateTime = new Date();
        this.plansId = Arrays.asList(0,1,2,3);
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
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

    public String getJobQueueName() {
        return jobQueueName;
    }

    public void setJobQueueName(String jobQueueName) {
        this.jobQueueName = jobQueueName;
    }

    public int getSubPlanAmounts() {
        return subPlanAmounts;
    }

    public void setSubPlanAmounts(int subPlanAmounts) {
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

    public List<Integer> getPlansId() {
        return plansId;
    }

    public void setPlansId(List<Integer> plansId) {
        this.plansId = plansId;
    }

    @Override
    public String toString() {
        return "JobInputInfoVO{" +
                "jobId='" + jobId + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobRemark='" + jobRemark + '\'' +
                ", jobCreateTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(jobCreateTime) +
                ", jobType=" + jobType +
                ", jobQueueName='" + jobQueueName + '\'' +
                ", subPlanAmounts='" + subPlanAmounts + '\'' +
                ", ignoreFails=" + ignoreFails +
                ", isSafe=" + isSafe +
                ", isFreeze=" + isFreeze +
                ", retryCount=" + retryCount +
                ", isRunFails=" + isRunFails +
                ", rules=" + rules +
                ", plansId=" + plansId +
                '}';
    }
}
