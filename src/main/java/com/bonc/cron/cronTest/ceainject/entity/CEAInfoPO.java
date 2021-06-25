package com.bonc.cron.cronTest.ceainject.entity;

import java.util.Date;

/**
 * CEA 信息
 * @author ZhengHang
 * @create 2021-06-07 15:59
 */
public class CEAInfoPO{
    private int id;
    private String name;
    private String ip;
    private Date createTime;
    private String remark;
    private int status;

    public CEAInfoPO(int id, String name, String ip, Date createTime, String remark, int status) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.createTime = createTime;
        this.remark = remark;
        this.status = status;
    }

    /**
     * 给insert操作使用的构造类*/
    public CEAInfoPO( String name, String ip, Date createTime, String remark, int status) {
        this.name = name;
        this.ip = ip;
        this.createTime = createTime;
        this.remark = remark;
        this.status = status;
    }

    public CEAInfoPO(int id , int status){
        this.id = id;
        this.status = status;
    }

    public CEAInfoPO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CEAInfoPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                '}';
    }
}
