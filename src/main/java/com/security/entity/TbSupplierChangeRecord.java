package com.security.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbSupplierChangeRecord)实体类
 *
 * @author makejava
 * @since 2023-07-04 20:40:22
 */
public class TbSupplierChangeRecord implements Serializable {
    private static final long serialVersionUID = -74652185806502773L;
    /**
     * 记录id
     */
    private Long recordId;
    /**
     * 供应商id
     */
    private Long supplierId;
    /**
     * 变更信息
     */
    private String changeInformation;
    /**
     * 变更时间
     */
    private Date chargeTime;
    /**
     * 变更人
     */
    private String changeUser;


    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getChangeInformation() {
        return changeInformation;
    }

    public void setChangeInformation(String changeInformation) {
        this.changeInformation = changeInformation;
    }

    public Date getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(Date chargeTime) {
        this.chargeTime = chargeTime;
    }

    public String getChangeUser() {
        return changeUser;
    }

    public void setChangeUser(String changeUser) {
        this.changeUser = changeUser;
    }

}

