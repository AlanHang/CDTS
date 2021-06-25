package com.bonc.cron.cronTest.jobmanager.entity;

/**
 * @author ZhengHang
 * @create 2021-06-09 17:21
 */
public class ExecuteCondition {
    private int totalCount;
    private int finishCount;
    private int successCount;
    private int failCount;

    public ExecuteCondition() {
    }

    public ExecuteCondition(int totalCount, int finishCount, int successCount, int failCount) {
        this.totalCount = totalCount;
        this.finishCount = finishCount;
        this.successCount = successCount;
        this.failCount = failCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(int finishCount) {
        this.finishCount = finishCount;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getFailCount() {
        return failCount;
    }

    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    @Override
    public String toString() {
        return "ExecuteCondition{" +
                "totalCount=" + totalCount +
                ", finishCount=" + finishCount +
                ", successCount=" + successCount +
                ", failCount=" + failCount +
                '}';
    }
}
