package com.bonc.cron.cronTest.test.mapper;

import com.bonc.cron.cronTest.test.TaskDO;
import com.bonc.cron.cronTest.test.TaskVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-08 17:18
 */
public interface TaskMapper {

    TaskDO get(Long id);

    List<TaskDO> list();

    List<TaskVO> listTaskVoByDesc(@Param("desc") String desc);

    int save(TaskDO task);

    int update(TaskDO task);

    int remove(Long id);

    int removeBatch(Long[] ids);
}
