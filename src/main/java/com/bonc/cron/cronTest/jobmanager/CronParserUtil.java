package com.bonc.cron.cronTest.jobmanager;

import com.bonc.cron.cronTest.jobmanager.entity.JobInputInfoVO;

import java.util.Calendar;

/**
 * @author ZhengHang
 * @create 2021-06-11 11:36
 */
public class CronParserUtil {

    //空格分隔符
    private static final char separate =' ';

    public static String getCron(JobInputInfoVO rules){
        StringBuffer cron = new StringBuffer();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(rules.getRules().startTime);
        if (rules.getJobType() == 0){
            cron.append(calendar.get(Calendar.SECOND));
            cron.append(separate);
            cron.append(calendar.get(Calendar.MINUTE));
            cron.append(separate);
            cron.append(calendar.get(Calendar.HOUR_OF_DAY));
            cron.append(separate);
            cron.append(calendar.get(Calendar.DATE));
            cron.append(separate);
            cron.append(calendar.get(Calendar.MONTH));
            cron.append(separate);
            cron.append('?');
            cron.append(separate);
            cron.append(calendar.get(Calendar.YEAR));
        }else {
            cron.append(calendar.get(Calendar.SECOND));
            cron.append(separate);
            cron.append(calendar.get(Calendar.MINUTE));
            cron.append(separate);
            cron.append(calendar.get(Calendar.HOUR_OF_DAY));
            cron.append(separate);
            if (rules.getRules().isMonth){//按月
                cron.append(rules.getRules().dayOfMonth);
                cron.append(separate);
                cron.append('*');
                cron.append(separate);
                cron.append('?');
            }else if (rules.getRules().isEveryDay){//每天
                cron.append('*');
                cron.append(separate);
                cron.append('*');
                cron.append(separate);
                cron.append('?');
            }else {//按周几
                cron.append('?');
                cron.append(separate);
                cron.append('*');
                cron.append(separate);
                if (rules.getRules().isSunday){
                    cron.append(1);
                    cron.append(',');
                }
                if (rules.getRules().isMonday){
                    cron.append(2);
                    cron.append(',');
                }
                if (rules.getRules().isTuesday){
                    cron.append(3);
                    cron.append(',');
                }
                if (rules.getRules().isWednesday){
                    cron.append(4);
                    cron.append(',');
                }
                if (rules.getRules().isThursday){
                    cron.append(5);
                    cron.append(',');
                }
                if (rules.getRules().isFriday){
                    cron.append(6);
                    cron.append(',');
                }
                if (rules.getRules().isSaturday){
                    cron.append(7);
                    cron.append(',');
                }
                cron.deleteCharAt(cron.length()-1);
            }
        }
        return cron.toString();
    }
}
