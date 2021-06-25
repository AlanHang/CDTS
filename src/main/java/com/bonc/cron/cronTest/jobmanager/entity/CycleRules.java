package com.bonc.cron.cronTest.jobmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用来记录前端选中的周期
 * @author ZhengHang
 * @create 2021-06-11 11:21
 */
public class CycleRules {

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    public Date startTime;

    public boolean isMonth = false;

    public int dayOfMonth;

    public boolean isMonday = false;

    public boolean isTuesday = false;

    public boolean isWednesday = false;

    public boolean isThursday = false;

    public boolean isFriday = false ;

    public boolean isSaturday = false;

    public boolean isSunday = false;

    public boolean isEveryDay= false;

    @Override
    public String toString() {
        return "CycleRules{" +
                "startTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime) +
                ", isMonth=" + isMonth +
                ", dayOfMonth=" + dayOfMonth +
                ", isMonday=" + isMonday +
                ", isTuesday=" + isTuesday +
                ", isWednesday=" + isWednesday +
                ", isThursday=" + isThursday +
                ", isFriday=" + isFriday +
                ", isSaturday=" + isSaturday +
                ", isSunday=" + isSunday +
                ", isEveryDay=" + isEveryDay +
                '}';
    }
}
