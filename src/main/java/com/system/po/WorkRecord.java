package com.system.po;

import java.util.Date;

public class WorkRecord {

    private Integer wrId;
    private Integer teaId;
    private Date createTime;
    private Date updateTime;
    private String description;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public Integer getWrId() {
        return wrId;
    }

    public void setWrId(Integer wrId) {
        this.wrId = wrId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
