package com.bonc.cron.cronTest.ceainject.entity;

/**
 * cea下行云状态信息
 * @author ZhengHang
 * @create 2021-06-07 16:11
 */
public class CEAClusterStatusPO {
    protected int ceaId;
    protected int clusterId;
    protected int clusterStatus;

    public CEAClusterStatusPO(int ceaId, int clusterId, int clusterStatus) {
        this.ceaId = ceaId;
        this.clusterId = clusterId;
        this.clusterStatus = clusterStatus;
    }

    public CEAClusterStatusPO() {
    }

    public int getCeaId() {
        return ceaId;
    }

    public void setCeaId(int ceaId) {
        this.ceaId = ceaId;
    }

    public int getClusterId() {
        return clusterId;
    }

    public void setClusterId(int clusterId) {
        this.clusterId = clusterId;
    }

    public int getClusterStatus() {
        return clusterStatus;
    }

    public void setClusterStatus(int clusterStatus) {
        this.clusterStatus = clusterStatus;
    }
}
