package com.bonc.cron.cronTest.jobmanager.dao;

import com.bonc.cron.cronTest.jobmanager.entity.SubTaskPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-10 14:44
 */
@Mapper
public interface SubTaskDao {

    List<SubTaskPO> selectSubTasks(@Param("planHisId") int planHisId, @Param("runStatus") int runStatus);
}
