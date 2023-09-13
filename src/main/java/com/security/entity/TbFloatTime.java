package com.security.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbFloatTime)实体类
 *
 * @author makejava
 * @since 2023-07-21 10:23:02
 */
public class TbFloatTime implements Serializable {
    private static final long serialVersionUID = 350696971500347297L;
    
    private Long id;
    
    private String projectId;
    /**
     * 可上下浮动值，预测的天数和分析的天数相差不能超过这个数
     */
    private Integer floatNum;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getFloatNum() {
        return floatNum;
    }

    public void setFloatNum(Integer floatNum) {
        this.floatNum = floatNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

