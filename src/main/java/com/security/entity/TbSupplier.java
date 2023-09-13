package com.security.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbSupplier)实体类
 *
 * @author makejava
 * @since 2023-07-04 20:40:22
 */
public class TbSupplier implements Serializable {
    private static final long serialVersionUID = -82924363062643059L;
    /**
     * 供应商id
     */
    private Long supplierId;
    /**
     * 供应商(单位)名称
     */
    private String supplierName;
    /**
     * 统一信用代码
     */
    private String uniformCreditCode;
    /**
     * 企业类型id（字典）
     */
    private String xtDictSupplier;
    /**
     * 省市地址
     */
    private String provinces;
    /**
     * 详细地址
     */
    private String detailedAddress;
    /**
     * 法定代表人
     */
    private String legalRepresentative;
    /**
     * 成立日期
     */
    private Date establishmentDate;
    /**
     * 注册资本（万）
     */
    private Double registeredCapital;
    /**
     * 经营期限
     */
    private String operatingPeriod;
    /**
     * 营业执照
     */
    private String businessLicense;
    /**
     * 信用等级（字典）
     */
    private String xtDictRating;
    /**
     * 业绩
     */
    private String performance;
    /**
     * 人员规模
     */
    private String scale;
    /**
     * 资质
     */
    private String certification;
    /**
     * 供应商简介
     */
    private String supplierProfile;
    /**
     * (字典)审核状态:1、审核中，2、已通过，3、未通过
     */
    private String approvalState;
    /**
     * 是否拉黑:0、否，1、是
     */
    private String blackFlag;
    /**
     * 拉黑备注
     */
    private String blackRemark;
    /**
     * 是否经过审核：0、否，1、是
     */
    private String approvalFlag;


    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getUniformCreditCode() {
        return uniformCreditCode;
    }

    public void setUniformCreditCode(String uniformCreditCode) {
        this.uniformCreditCode = uniformCreditCode;
    }

    public String getXtDictSupplier() {
        return xtDictSupplier;
    }

    public void setXtDictSupplier(String xtDictSupplier) {
        this.xtDictSupplier = xtDictSupplier;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public Double getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Double registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getOperatingPeriod() {
        return operatingPeriod;
    }

    public void setOperatingPeriod(String operatingPeriod) {
        this.operatingPeriod = operatingPeriod;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getXtDictRating() {
        return xtDictRating;
    }

    public void setXtDictRating(String xtDictRating) {
        this.xtDictRating = xtDictRating;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getSupplierProfile() {
        return supplierProfile;
    }

    public void setSupplierProfile(String supplierProfile) {
        this.supplierProfile = supplierProfile;
    }

    public String getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(String approvalState) {
        this.approvalState = approvalState;
    }

    public String getBlackFlag() {
        return blackFlag;
    }

    public void setBlackFlag(String blackFlag) {
        this.blackFlag = blackFlag;
    }

    public String getBlackRemark() {
        return blackRemark;
    }

    public void setBlackRemark(String blackRemark) {
        this.blackRemark = blackRemark;
    }

    public String getApprovalFlag() {
        return approvalFlag;
    }

    public void setApprovalFlag(String approvalFlag) {
        this.approvalFlag = approvalFlag;
    }

}

