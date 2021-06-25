package com.bonc.cron.cronTest.ceainject.entity;

import java.util.Map;

/**
 * 行云集群的信息，实际操作的类
 * @author ZhengHang
 * @create 2021-06-07 17:05
 */
public class CEACluster extends CEAClusterStatusPO {

    private Map<String,String> clusterInfo;

    public CEACluster(int ceaId, String clusterId, int clusterStatus, Map<String, String> clusterInfo) {
        super(ceaId, clusterId, clusterStatus);
        this.clusterInfo = clusterInfo;
    }

    public CEACluster() {
    }

    public Map<String, String> getClusterInfo() {
        return clusterInfo;
    }

    public void setClusterInfo(Map<String, String> clusterInfo) {
        this.clusterInfo = clusterInfo;
    }

    public boolean addParame(String key,String value){
        for (ClusterKey clusterKey : ClusterKey.values()) {
            if (clusterKey.name().equals(key)){
                clusterInfo.put(key,value);
                return true;
            }
        }
        return false;
    }
}
