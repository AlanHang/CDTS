package com.bonc.cron.cronTest.ceainject.dao;

import com.bonc.cron.cronTest.ceainject.entity.CEAClusterStatusPO;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-08 9:56
 */
public interface ClusterStatusDao {
    int addClusterStatus(CEAClusterStatusPO status);
    int deleteClusterStatus(int ceaId, String clusterId);
    int updateClusterStatus(CEAClusterStatusPO status);
    List<CEAClusterStatusPO> selectAllClusterStatus(int ceaId);
    int selectOneClusterStatus(int ceaId, String clusterId);
}
