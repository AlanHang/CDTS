package com.bonc.cron.cronTest.utils;

import com.bonc.cron.cronTest.jobmanager.entity.CycleRules;
import com.bonc.cron.cronTest.jobmanager.entity.JobInputInfoVO;

import java.util.Calendar;
/**
 * @author ZhengHang
 * @create 2021-06-11 11:36
 */
public class CronParserUtil {

    //空格分隔符
    private static final String separate = " ";

    /**
     * @param rules job传入的信息
     * @return cron表达式
     */
    public static String getCron(JobInputInfoVO rules) {
        StringBuffer cron = new StringBuffer();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(rules.getRules().startTime);
        if (rules.getJobType() == 0) {
            cron.append(calendar.get(Calendar.SECOND));
            cron.append(separate);
            cron.append(calendar.get(Calendar.MINUTE));
            cron.append(separate);
            cron.append(calendar.get(Calendar.HOUR_OF_DAY));
            cron.append(separate);
            cron.append(calendar.get(Calendar.DATE));
            cron.append(separate);
            cron.append((calendar.get(Calendar.MONTH)+1));
            cron.append(separate);
            cron.append('?');
            cron.append(separate);
            cron.append(calendar.get(Calendar.YEAR));
        } else {
            cron.append(calendar.get(Calendar.SECOND));
            cron.append(separate);
            cron.append(calendar.get(Calendar.MINUTE));
            cron.append(separate);
            cron.append(calendar.get(Calendar.HOUR_OF_DAY));
            cron.append(separate);
            if (rules.getRules().isMonth) {//按月
                cron.append(rules.getRules().dayOfMonth);
                cron.append(separate);
                cron.append('*');
                cron.append(separate);
                cron.append('?');
            } else if (rules.getRules().isEveryDay) {//每天
                cron.append('*');
                cron.append(separate);
                cron.append('*');
                cron.append(separate);
                cron.append('?');
            } else {//按周几
                cron.append('?');
                cron.append(separate);
                cron.append('*');
                cron.append(separate);
                if (rules.getRules().isSunday) {
                    cron.append(1);
                    cron.append(',');
                }
                if (rules.getRules().isMonday) {
                    cron.append(2);
                    cron.append(',');
                }
                if (rules.getRules().isTuesday) {
                    cron.append(3);
                    cron.append(',');
                }
                if (rules.getRules().isWednesday) {
                    cron.append(4);
                    cron.append(',');
                }
                if (rules.getRules().isThursday) {
                    cron.append(5);
                    cron.append(',');
                }
                if (rules.getRules().isFriday) {
                    cron.append(6);
                    cron.append(',');
                }
                if (rules.getRules().isSaturday) {
                    cron.append(7);
                    cron.append(',');
                }
                cron.deleteCharAt(cron.length() - 1);
            }
        }
        return cron.toString();
    }

    /**
     * @param cron    cron表达式
     * @param jobType job的类型0/1
     * @return 策略信息
     */
    public static CycleRules parseCron(String cron, int jobType) {
        CycleRules cycleRules = new CycleRules();
        String[] split = cron.split(separate);
        if (split.length < 6) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        if (jobType == 0) {
            if (split.length < 7) {
                return null;
            }
            int second = Integer.parseInt(split[0]);
            int minute = Integer.parseInt(split[1]);
            int hour = Integer.parseInt(split[2]);
            int day = Integer.parseInt(split[3]);
            int month = Integer.parseInt(split[4]) - 1;
            int year = Integer.parseInt(split[6]);
            calendar.set(year, month, day, hour, minute, second);
            cycleRules.startTime = calendar.getTime();
            return cycleRules;
        } else {
            int second = Integer.parseInt(split[0]);
            int minute = Integer.parseInt(split[1]);
            int hour = Integer.parseInt(split[2]);
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);
            calendar.set(Calendar.SECOND, second);
            cycleRules.startTime = calendar.getTime();
            if (split[3].equals("*")) {
                //每天触发
                cycleRules.isEveryDay = true;
            } else if (split[3].equals("?")) {
                //每周触发
                String[] weeks = split[5].split(",");
                for (String week : weeks) {
                    switch (week) {
                        case "1":
                            cycleRules.isSunday = true;
                            break;
                        case "2":
                            cycleRules.isMonday = true;
                            break;
                        case "3":
                            cycleRules.isTuesday = true;
                            break;
                        case "4":
                            cycleRules.isWednesday = true;
                            break;
                        case "5":
                            cycleRules.isThursday = true;
                            break;
                        case "6":
                            cycleRules.isFriday = true;
                            break;
                        case "7":
                            cycleRules.isSaturday = true;
                            break;
                    }
                }
            } else {
                cycleRules.isMonth = true;
                cycleRules.dayOfMonth = Integer.parseInt(split[3]);
            }
        }
        return cycleRules;
    }
}
