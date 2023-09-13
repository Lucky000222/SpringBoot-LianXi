package com.security.entity;

import java.io.Serializable;

/**
 * 交工计量清单(TbHisMeterageList)实体类
 *
 * @author makejava
 * @since 2023-05-19 16:22:12
 */
public class TbHisMeterageList implements Serializable {
    private static final long serialVersionUID = -99036968992487141L;
    /**
     * 主键
     */
    private String id;
    /**
     * 组织机构ID
     */
    private String orgId;
    /**
     * 交工证书主键
     */
    private String certificateId;
    /**
     * wbsid
     */
    private String wbsId;
    /**
     * 工程编号
     */
    private String wbsCode;
    /**
     * 工程名称
     */
    private String wbsName;
    /**
     * 工程编号串 工程编号:分部/分项/../计量单元
     */
    private String wbsCodes;
    /**
     * 工程名称:分部/分项/../计量单元
     */
    private String wbsNames;
    /**
     * 子目号
     */
    private String subitemCode;
    /**
     * 子目名称
     */
    private String subitemName;
    /**
     * 计量单位
     */
    private String meterageUnit;
    /**
     * 修编后数量
     */
    private Double correctionNumber;
    /**
     * 申报数量
     */
    private Double applyNumber;
    /**
     * 核定数量
     */
    private Double checkNumber;
    /**
     * 本次允许计量
     */
    private Double currentAllowNumber;
    /**
     * 累积允许计量
     */
    private Double allowNumber;
    /**
     * 类型（1:合同,2:变更）
     */
    private String meteragetype;
    /**
     * 是否已调差完成 0 未完成   1已完成 
     */
    private String accomplish;
    /**
     * 累积交工
     */
    private Double cumulativeNumber;
    /**
     * 标段分项清单id
     */
    private String subitemId;
    /**
     * 关联标段id
     */
    private String sectionId;
    /**
     * 对应的wbs层级编号
     */
    private String longWbsCode;
    /**
     * 清单id
     */
    private String listId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getWbsId() {
        return wbsId;
    }

    public void setWbsId(String wbsId) {
        this.wbsId = wbsId;
    }

    public String getWbsCode() {
        return wbsCode;
    }

    public void setWbsCode(String wbsCode) {
        this.wbsCode = wbsCode;
    }

    public String getWbsName() {
        return wbsName;
    }

    public void setWbsName(String wbsName) {
        this.wbsName = wbsName;
    }

    public String getWbsCodes() {
        return wbsCodes;
    }

    public void setWbsCodes(String wbsCodes) {
        this.wbsCodes = wbsCodes;
    }

    public String getWbsNames() {
        return wbsNames;
    }

    public void setWbsNames(String wbsNames) {
        this.wbsNames = wbsNames;
    }

    public String getSubitemCode() {
        return subitemCode;
    }

    public void setSubitemCode(String subitemCode) {
        this.subitemCode = subitemCode;
    }

    public String getSubitemName() {
        return subitemName;
    }

    public void setSubitemName(String subitemName) {
        this.subitemName = subitemName;
    }

    public String getMeterageUnit() {
        return meterageUnit;
    }

    public void setMeterageUnit(String meterageUnit) {
        this.meterageUnit = meterageUnit;
    }

    public Double getCorrectionNumber() {
        return correctionNumber;
    }

    public void setCorrectionNumber(Double correctionNumber) {
        this.correctionNumber = correctionNumber;
    }

    public Double getApplyNumber() {
        return applyNumber;
    }

    public void setApplyNumber(Double applyNumber) {
        this.applyNumber = applyNumber;
    }

    public Double getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(Double checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Double getCurrentAllowNumber() {
        return currentAllowNumber;
    }

    public void setCurrentAllowNumber(Double currentAllowNumber) {
        this.currentAllowNumber = currentAllowNumber;
    }

    public Double getAllowNumber() {
        return allowNumber;
    }

    public void setAllowNumber(Double allowNumber) {
        this.allowNumber = allowNumber;
    }

    public String getMeteragetype() {
        return meteragetype;
    }

    public void setMeteragetype(String meteragetype) {
        this.meteragetype = meteragetype;
    }

    public String getAccomplish() {
        return accomplish;
    }

    public void setAccomplish(String accomplish) {
        this.accomplish = accomplish;
    }

    public Double getCumulativeNumber() {
        return cumulativeNumber;
    }

    public void setCumulativeNumber(Double cumulativeNumber) {
        this.cumulativeNumber = cumulativeNumber;
    }

    public String getSubitemId() {
        return subitemId;
    }

    public void setSubitemId(String subitemId) {
        this.subitemId = subitemId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getLongWbsCode() {
        return longWbsCode;
    }

    public void setLongWbsCode(String longWbsCode) {
        this.longWbsCode = longWbsCode;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

}

