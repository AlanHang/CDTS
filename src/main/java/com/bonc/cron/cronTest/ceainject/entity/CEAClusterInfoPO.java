package com.bonc.cron.cronTest.ceainject.entity;

/**
 * CEA行云的配置码表信息
 * @author ZhengHang
 * @create 2021-06-07 16:14
 */
public class CEAClusterInfoPO {
    private int ceaId;
    private String clusterId;
    //key值为ClusterKey枚举类中的name
    private String clusterKey;
    private String clusterValue;

    public CEAClusterInfoPO(int ceaId, String clusterId, String clusterKey, String clusterValue) {
        this.ceaId = ceaId;
        this.clusterId = clusterId;
        this.clusterKey = clusterKey;
        this.clusterValue = clusterValue;
    }

    public CEAClusterInfoPO() {
    }

    public int getCeaId() {
        return ceaId;
    }

    public void setCeaId(int ceaId) {
        this.ceaId = ceaId;
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterKey() {
        return clusterKey;
    }

    public void setClusterKey(String clusterKey) {
        this.clusterKey = clusterKey;
    }

    public String getClusterValue() {
        return clusterValue;
    }

    public void setClusterValue(String clusterValue) {
        this.clusterValue = clusterValue;
    }

    @Override
    public String toString() {
        return "CEAClusterInfoPO{" +
                "ceaId=" + ceaId +
                ", clusterId='" + clusterId + '\'' +
                ", clusterKey='" + clusterKey + '\'' +
                ", clusterValue='" + clusterValue + '\'' +
                '}';
    }
}
