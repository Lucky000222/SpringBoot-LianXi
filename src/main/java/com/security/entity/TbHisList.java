package com.security.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 清单实例(TbHisList)实体类
 *
 * @author makejava
 * @since 2023-05-19 16:22:12
 */
public class TbHisList implements Serializable {
    private static final long serialVersionUID = -74360363821843386L;
    /**
     * 清单编码
     */
    private String id;
    /**
     * 父id
     */
    private String parentId;
    /**
     * 子目号
     */
    private String subitemCode;
    /**
     * 子目名称
     */
    private String subitemName;
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
     * 标段编码
     */
    private String sectionCode;
    /**
     * 版本ID
     */
    private String versionId;
    /**
     * 工程量计量描述
     */
    private String description;
    /**
     * 章节
     */
    private String chapter;
    /**
     * 计量单位
     */
    private String meterageUnit;
    /**
     * 工程内容
     */
    private String projectContent;
    /**
     * 单价
     */
    private Double price;
    /**
     * 合同数量
     */
    private Double contractNumber;
    /**
     * 章节类型 100 总则200 路基300 路面400 桥梁、涵洞500 隧道600 安全设施及预管理线700 绿化及环境保护设施800 房建900 机电
     */
    private String chapterType;
    /**
     * 是否特殊项
     */
    private String isPecial;
    /**
     * 清单类型（合同清单，临时清单，变更清单，  材料清单
     */
    private String listType;
    /**
     * 状态
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
     * 是否是叶子节点
     */
    private Object isLeaf;
    /**
     * 项目清单ID
     */
    private String projectListId;
    /**
     * 组织机构ID
     */
    private String orgId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getMeterageUnit() {
        return meterageUnit;
    }

    public void setMeterageUnit(String meterageUnit) {
        this.meterageUnit = meterageUnit;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Double contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getChapterType() {
        return chapterType;
    }

    public void setChapterType(String chapterType) {
        this.chapterType = chapterType;
    }

    public String getIsPecial() {
        return isPecial;
    }

    public void setIsPecial(String isPecial) {
        this.isPecial = isPecial;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
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

    public Object getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Object isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getProjectListId() {
        return projectListId;
    }

    public void setProjectListId(String projectListId) {
        this.projectListId = projectListId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

}

