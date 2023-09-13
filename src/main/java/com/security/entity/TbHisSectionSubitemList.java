package com.security.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 标段分项清单(TbHisSectionSubitemList)实体类
 *
 * @author makejava
 * @since 2023-05-19 16:22:12
 */
public class TbHisSectionSubitemList implements Serializable {
    private static final long serialVersionUID = -12858420390543806L;
    /**
     * 主键
     */
    private String id;
    /**
     * wbsid
     */
    private String wbsId;
    /**
     * 工程编号
     */
    private String wbsCode;
    /**
     * 清单id
     */
    private String listId;
    /**
     * 工程名称
     */
    private String wbsName;
    /**
     * 起桩号
     */
    private String startStake;
    /**
     * 止桩号
     */
    private String endStake;
    /**
     * 子目号
     */
    private String subitemCode;
    /**
     * 子目名称
     */
    private String subitemName;
    /**
     * 合同数量
     */
    private Double contractNumber;
    /**
     * 合同金额
     */
    private Double checkAmount;
    /**
     * 类型（1:合同,2:变更 3 修编）
     */
    private String type;
    /**
     * 类型（1:主体清单,2:机电清单,3:房建清单,99:材料清单）
     */
    private String category;
    /**
     * 状态:0:未完成         1:已完成
     */
    private String status;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 修改时间
     */
    private Date modifyDateTime;
    /**
     * 排序号
     */
    private Integer sortedOrder;
    /**
     * 逻辑删除
     */
    private String delFlag;
    /**
     * 备注
     */
    private String remark;
    /**
     * WBS版本ID
     */
    private String versionId;
    /**
     * 项目ID
     */
    private String projectId;
    /**
     * 项目CODE
     */
    private String projectCode;
    /**
     * 标段ID
     */
    private String sectionId;
    /**
     * 标段CODE
     */
    private String sectionCode;
    /**
     * 组织机构id
     */
    private String orgId;
    /**
     * 允许计量比例
     */
    private Double allowProportion;
    /**
     * 变更/修编编号
     */
    private String alterCode;
    /**
     * 计量单位
     */
    private String meterageUnit;
    /**
     * 单价
     */
    private Double price;
    /**
     * 章节类型
     */
    private String chapterType;
    /**
     * 填写的图纸页码，后台解析关联
     */
    private String drawing;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getWbsName() {
        return wbsName;
    }

    public void setWbsName(String wbsName) {
        this.wbsName = wbsName;
    }

    public String getStartStake() {
        return startStake;
    }

    public void setStartStake(String startStake) {
        this.startStake = startStake;
    }

    public String getEndStake() {
        return endStake;
    }

    public void setEndStake(String endStake) {
        this.endStake = endStake;
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

    public Double getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Double contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Double getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(Double checkAmount) {
        this.checkAmount = checkAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyDateTime() {
        return modifyDateTime;
    }

    public void setModifyDateTime(Date modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    public Integer getSortedOrder() {
        return sortedOrder;
    }

    public void setSortedOrder(Integer sortedOrder) {
        this.sortedOrder = sortedOrder;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Double getAllowProportion() {
        return allowProportion;
    }

    public void setAllowProportion(Double allowProportion) {
        this.allowProportion = allowProportion;
    }

    public String getAlterCode() {
        return alterCode;
    }

    public void setAlterCode(String alterCode) {
        this.alterCode = alterCode;
    }

    public String getMeterageUnit() {
        return meterageUnit;
    }

    public void setMeterageUnit(String meterageUnit) {
        this.meterageUnit = meterageUnit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getChapterType() {
        return chapterType;
    }

    public void setChapterType(String chapterType) {
        this.chapterType = chapterType;
    }

    public String getDrawing() {
        return drawing;
    }

    public void setDrawing(String drawing) {
        this.drawing = drawing;
    }

}

