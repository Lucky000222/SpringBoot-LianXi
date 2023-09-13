package com.security.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 工序报验(TbHisProcessCheck)实体类
 *
 * @author makejava
 * @since 2023-05-19 16:22:12
 */
public class TbHisProcessCheck implements Serializable {
    private static final long serialVersionUID = -52732824670520420L;
    /**
     * 主键
     */
    private String id;
    /**
     * 组织机构ID
     */
    private String orgId;
    /**
     * 报验编号
     */
    private String checkCode;
    /**
     * 分部分项id
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
     * 工序id
     */
    private String processId;
    /**
     * 工序编号
     */
    private String processCode;
    /**
     * 工序名称
     */
    private String processName;
    /**
     * 完成部位名称
     */
    private String positionName;
    /**
     * 完成部位占比
     */
    private String positionProportion;
    /**
     * 要求监理到场时间
     */
    private Date arriveTime;
    /**
     * 监理检查是否可继续进行
     */
    private Object isContinue;
    /**
     * 监理检查是否符合要求
     */
    private Object result;
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
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 备注
     */
    private String remark;
    /**
     * 流程状态 1:未开始
            2:进行中
            3:已结束
     */
    private String state;
    /**
     * 流程实例ID
     */
    private String flowId;
    /**
     * 承包单位名称
     */
    private String contractingUnit;
    /**
     * 监理单位
     */
    private String supervisorUnit;
    /**
     * 流程生效时间
     */
    private Date effectTime;
    /**
     * 工序报验pdf文件id
     */
    private String gxPdfId;
    /**
     * 业务id
     */
    private String businessId;
    /**
     * 部位ID
     */
    private String positionId;
    /**
     * 审批日期
     */
    private Date endTime;
    /**
     * 发起人
     */
    private String submitUser;


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

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
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

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionProportion() {
        return positionProportion;
    }

    public void setPositionProportion(String positionProportion) {
        this.positionProportion = positionProportion;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Object getIsContinue() {
        return isContinue;
    }

    public void setIsContinue(Object isContinue) {
        this.isContinue = isContinue;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getContractingUnit() {
        return contractingUnit;
    }

    public void setContractingUnit(String contractingUnit) {
        this.contractingUnit = contractingUnit;
    }

    public String getSupervisorUnit() {
        return supervisorUnit;
    }

    public void setSupervisorUnit(String supervisorUnit) {
        this.supervisorUnit = supervisorUnit;
    }

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    public String getGxPdfId() {
        return gxPdfId;
    }

    public void setGxPdfId(String gxPdfId) {
        this.gxPdfId = gxPdfId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSubmitUser() {
        return submitUser;
    }

    public void setSubmitUser(String submitUser) {
        this.submitUser = submitUser;
    }

}

