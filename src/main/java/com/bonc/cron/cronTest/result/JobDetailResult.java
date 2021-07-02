package com.bonc.cron.cronTest.result;

import com.bonc.cron.cronTest.jobmanager.entity.JobDetailsVO;

/**
 * @author ZhengHang
 * @create 2021-07-01 19:51
 */
public class JobDetailResult {

    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;

    private JobDetailsVO result;

    public JobDetailResult(int pageNum, int pageSize, long totalSize, int totalPages, JobDetailsVO result) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.totalPages = totalPages;
        this.result = result;
    }

    public JobDetailResult() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public JobDetailsVO getResult() {
        return result;
    }

    public void setResult(JobDetailsVO result) {
        this.result = result;
    }
}
