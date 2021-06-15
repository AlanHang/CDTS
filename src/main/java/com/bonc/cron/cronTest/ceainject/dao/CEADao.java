package com.bonc.cron.cronTest.ceainject.dao;

import com.bonc.cron.cronTest.ceainject.entity.CEAInfoPO;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-07 17:32
 */
public interface CEADao {

    int addCEAInfo(CEAInfoPO info);

    int deleteCEAInfo(int ceaId);

    int updateCEAInfo(CEAInfoPO info);

    List<CEAInfoPO> selectAllCEAInfo();

    CEAInfoPO selectOneCEAInfo(int ceaId);
}
