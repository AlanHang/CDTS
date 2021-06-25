package com.bonc.cron.cronTest.ceainject.dao;

import com.bonc.cron.cronTest.ceainject.entity.CEAClusterInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-08 10:01
 */
@Mapper
public interface CEAClusterInfoDao {

    int addClusterInfo(List<CEAClusterInfoPO> info);

    int deleteClusterInfo(@Param("ceaId") int ceaId, @Param("clusterId") String clusterId);

    int deleteClusterInfoByCEAId(@Param("ceaId") int ceaId);

    int updateClusterInfo(List<CEAClusterInfoPO> info);

    List<CEAClusterInfoPO> selectAllClusterInfo(@Param("ceaId")int ceaId);

    List<CEAClusterInfoPO> selectOneClusterInfo(@Param("ceaId")int ceaId, @Param("clusterId")String clusterId);
}
