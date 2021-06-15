package com.bonc.cron.cronTest.ceainject.dao;

import com.bonc.cron.cronTest.ceainject.entity.CEAClusterInfoPO;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-08 10:01
 */
public interface CEAClusterInfoDao {
    int addClusterInfo(List<CEAClusterInfoPO> infos);
    int deleteClusterInfo(int ceaId,String clusterId);
    int updateClusterInfo(List<CEAClusterInfoPO> infos);
    List<CEAClusterInfoPO> selectAllClusterInfo(int ceaId);
    List<CEAClusterInfoPO> selectOneClusterInfo(int ceaId, String clusterId);
}
