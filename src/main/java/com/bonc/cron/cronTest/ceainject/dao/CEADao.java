package com.bonc.cron.cronTest.ceainject.dao;

import com.bonc.cron.cronTest.ceainject.entity.CEAInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-07 17:32
 */
@Mapper
public interface CEADao {

    int addCEAInfo(CEAInfoPO info);

    int deleteCEAInfo(@Param("ceaId") int ceaId);

    int updateCEAInfo(CEAInfoPO info);

    List<CEAInfoPO> selectAllCEAInfo();

    CEAInfoPO selectOneCEAInfo(@Param("ceaId") int ceaId);
}
