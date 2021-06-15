package com.bonc.cron.cronTest.jobmanager.entity;

import java.util.Date;

/**
 * 用来记录前端选中的周期
 * @author ZhengHang
 * @create 2021-06-11 11:21
 */
public class CycleRules {
    public Date startTime;
    public boolean isMonth = false;
    public int dateOfMonth;
    public boolean isMonday = false;
    public boolean isTuesday = false;
    public boolean isWednesday = false;
    public boolean isThursday = false;
    public boolean isFriday = false ;
    public boolean isSaturday = false;
    public boolean isSunday = false;
    public boolean isEveryDay= false;
}
