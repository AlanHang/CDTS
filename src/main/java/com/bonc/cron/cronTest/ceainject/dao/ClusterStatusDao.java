package com.bonc.cron.cronTest.ceainject.dao;

import com.bonc.cron.cronTest.ceainject.entity.CEAClusterStatusPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-08 9:56
 */
@Mapper
public interface ClusterStatusDao {

    int addClusterStatus(CEAClusterStatusPO status);

    int deleteClusterStatus(@Param("ceaId") int ceaId, @Param("clusterId") String clusterId);

    int deleteClusterStatusByCEAId(@Param("ceaId") int ceaId);

    int updateClusterStatus(CEAClusterStatusPO status);

    List<CEAClusterStatusPO> selectAllClusterStatus(@Param("ceaId") int ceaId);

    int selectOneClusterStatus(@Param("ceaId") int ceaId, @Param("clusterId") String clusterId);
}
