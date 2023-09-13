package com.security.entity;

import java.io.Serializable;

/**
 * 工序报验对应材料清单量(TbHisCheckList)实体类
 *
 * @author makejava
 * @since 2023-05-19 16:22:12
 */
public class TbHisCheckList implements Serializable {
    private static final long serialVersionUID = 687330390748266036L;
    /**
     * 主键
     */
    private String id;
    /**
     * 组织机构ID
     */
    private String orgId;
    /**
     * 工序报验主键
     */
    private String checkId;
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
     * 子目号-材料清单
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
     * 清单数量
     */
    private Double correctionNumber;
    /**
     * 核定数量
     */
    private Double checkNumber;
    /**
     * 类型（3 材料清单）
     */
    private String meteragetype;
    /**
     * 是否已调差完成 0 未完成   1已完成 
     */
    private String accomplish;


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

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
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

    public Double getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(Double checkNumber) {
        this.checkNumber = checkNumber;
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

}

