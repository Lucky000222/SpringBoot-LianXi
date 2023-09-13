package com.security.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * WBS实例(TbHisWbsInstance)实体类
 *
 * @author makejava
 * @since 2023-05-19 16:22:12
 */
public class TbHisWbsInstance implements Serializable {
    private static final long serialVersionUID = 248447358603277629L;
    /**
     * 主键
     */
    private String id;
    /**
     * 父节点ID
     */
    private String parentId;
    /**
     * 项目ID
     */
    private String projectId;
    /**
     * 项目编号(CODE)
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
     * 编号
     */
    private String wbsCode;
    /**
     * 长编码：标段.单位工程.分部.分项.工程单元
     */
    private String longWbsCode;
    /**
     * 名称
     */
    private String wbsName;
    /**
     * 层级编号
     */
    private String levelCode;
    /**
     * 系统WBSID对于分包，可以使用不同的前包的模板
     */
    private String systemWbsId;
    /**
     * 项目WBSID
     */
    private String projectWbsId;
    /**
     * 地标编号
     */
    private String localCode;
    /**
     * 国标编号
     */
    private String nationCode;
    /**
     * 配合计量单元
     */
    private String meterageUnit;
    /**
     * 通用/计量/质量
     */
    private String systemSign;
    /**
     * 工程划分类型（单位工程、分部、子分部、分项、子分项、工序或计量单元）
     */
    private String divideType;
    /**
     * 结构类别（路面、路基、桥梁、隧道）
     */
    private String structType;
    /**
     * 计量状态（未开始/进行中/已结束/超计量）
     */
    private String meterageState;
    /**
     * 开始桩号
     */
    private String startStake;
    /**
     * 终止桩号
     */
    private String endStake;
    /**
     * 允许计量比例
     */
    private Double allowRatio;
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
     * 组织机构id
     */
    private String orgId;
    /**
     * 是否叶子节点
     */
    private Object isLeaf;
    /**
     * 编号规则
     */
    private String wbsCodeProject;
    /**
     * 坐标集合
     */
    private String coordinate;
    /**
     * 流程状态 1:未开始 2:进行中 3:已结束
     */
    private String flowStatus;
    /**
     * 中心桩号
     */
    private String coreStake;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getWbsCode() {
        return wbsCode;
    }

    public void setWbsCode(String wbsCode) {
        this.wbsCode = wbsCode;
    }

    public String getLongWbsCode() {
        return longWbsCode;
    }

    public void setLongWbsCode(String longWbsCode) {
        this.longWbsCode = longWbsCode;
    }

    public String getWbsName() {
        return wbsName;
    }

    public void setWbsName(String wbsName) {
        this.wbsName = wbsName;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getSystemWbsId() {
        return systemWbsId;
    }

    public void setSystemWbsId(String systemWbsId) {
        this.systemWbsId = systemWbsId;
    }

    public String getProjectWbsId() {
        return projectWbsId;
    }

    public void setProjectWbsId(String projectWbsId) {
        this.projectWbsId = projectWbsId;
    }

    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public String getMeterageUnit() {
        return meterageUnit;
    }

    public void setMeterageUnit(String meterageUnit) {
        this.meterageUnit = meterageUnit;
    }

    public String getSystemSign() {
        return systemSign;
    }

    public void setSystemSign(String systemSign) {
        this.systemSign = systemSign;
    }

    public String getDivideType() {
        return divideType;
    }

    public void setDivideType(String divideType) {
        this.divideType = divideType;
    }

    public String getStructType() {
        return structType;
    }

    public void setStructType(String structType) {
        this.structType = structType;
    }

    public String getMeterageState() {
        return meterageState;
    }

    public void setMeterageState(String meterageState) {
        this.meterageState = meterageState;
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

    public Double getAllowRatio() {
        return allowRatio;
    }

    public void setAllowRatio(Double allowRatio) {
        this.allowRatio = allowRatio;
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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Object getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Object isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getWbsCodeProject() {
        return wbsCodeProject;
    }

    public void setWbsCodeProject(String wbsCodeProject) {
        this.wbsCodeProject = wbsCodeProject;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
    }

    public String getCoreStake() {
        return coreStake;
    }

    public void setCoreStake(String coreStake) {
        this.coreStake = coreStake;
    }

    public String getDrawing() {
        return drawing;
    }

    public void setDrawing(String drawing) {
        this.drawing = drawing;
    }

}

