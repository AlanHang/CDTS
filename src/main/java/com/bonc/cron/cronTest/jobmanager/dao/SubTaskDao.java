package com.bonc.cron.cronTest.jobmanager.dao;

import com.bonc.cron.cronTest.jobmanager.entity.SubTaskPO;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-10 14:44
 */
public interface SubTaskDao {

    List<SubTaskPO> selectSubTasks(int historyId,int planId);
}
