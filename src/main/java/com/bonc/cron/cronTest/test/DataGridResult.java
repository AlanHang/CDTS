package com.bonc.cron.cronTest.test;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-08 17:05
 */
public class DataGridResult {
    private int code;
    private String message;
    private long count;
    private List<?> data;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public long getCount() {
        return count;
    }
    public void setCount(long count) {
        this.count = count;
    }
    public List<?> getData() {
        return data;
    }
    public void setData(List<?> data) {
        this.data = data;
    }

}