package com.bonc.cron.cronTest.jobmanager.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-30 17:01
 */
public class JobReturnPO {
    private Integer jobId;
    private String jobName;
    private String jobRemark;
    private Date jobCreateTime;
    //标识job运行的类型，0为单次job,1为周期性job
    private Integer jobType;
    //标识job的状态，0为关闭，1为开启
    private Integer jobStatus;
    //执行队列的名称
    private String jobQueueName;
    private String jobHisId;
    private Date startTime;
    private String completeDetail;
    private Date endTime;

    public JobReturnPO(Integer jobId, String jobName, String jobRemark, Date jobCreateTime, Integer jobType,
                       Integer jobStatus, String jobQueueName, String jobHisId, Date startTime, String completeDetail,
                       Date endTime) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobRemark = jobRemark;
        this.jobCreateTime = jobCreateTime;
        this.jobType = jobType;
        this.jobStatus = jobStatus;
        this.jobQueueName = jobQueueName;
        this.jobHisId = jobHisId;
        this.startTime = startTime;
        this.completeDetail = completeDetail;
        this.endTime = endTime;
    }

    public JobReturnPO() {
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
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

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobQueueName() {
        return jobQueueName;
    }

    public void setJobQueueName(String jobQueueName) {
        this.jobQueueName = jobQueueName;
    }

    public String getJobHisId() {
        return jobHisId;
    }

    public void setJobHisId(String jobHisId) {
        this.jobHisId = jobHisId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getCompleteDetail() {
        return completeDetail;
    }

    public void setCompleteDetail(String completeDetail) {
        this.completeDetail = completeDetail;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "JobReturnPO{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", jobRemark='" + jobRemark + '\'' +
                ", jobCreateTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(jobCreateTime) +
                ", jobType=" + jobType +
                ", jobStatus=" + jobStatus +
                ", jobQueueName='" + jobQueueName + '\'' +
                ", jobHisId='" + jobHisId + '\'' +
                ", startTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime) +
                ", completeDetail='" + completeDetail + '\'' +
                ", endTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endTime) +
                '}';
    }
}
