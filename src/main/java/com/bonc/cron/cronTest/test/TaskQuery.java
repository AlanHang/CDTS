package com.bonc.cron.cronTest.test;

/**
 * @author ZhengHang
 * @create 2021-06-08 17:04
 */
public class TaskQuery extends BaseQuery {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // 任务描述
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}