package com.security.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 开工报告(TbHisStartReport)实体类
 *
 * @author makejava
 * @since 2023-05-19 16:22:12
 */
public class TbHisStartReport implements Serializable {
    private static final long serialVersionUID = -40806636625980608L;
    /**
     * 主键
     */
    private String id;
    /**
     * 组织机构ID
     */
    private String orgId;
    /**
     * 承包单位名称
     */
    private String contractingUnit;
    /**
     * 承包单位合同编号
     */
    private String contractingCode;
    /**
     * 开工编号
     */
    private String reportCode;
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
     * 桩号
     */
    private String stakeNumber;
    /**
     * 负责人id
     */
    private String leaderId;
    /**
     * 负责人姓名
     */
    private String leader;
    /**
     * 建议开工日期
     */
    private Date startDate;
    /**
     * 计划完工日期
     */
    private Date endDate;
    /**
     * 监理单位id
     */
    private String supervisorId;
    /**
     * 监理单位
     */
    private String supervisorUnit;
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
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 流程状态 1:未开始  2:进行中  3:已结束
     */
    private String state;
    /**
     * 流程实例ID
     */
    private String flowId;
    /**
     * 备注
     */
    private String remark;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 备注
     */
    private String businessId;
    /**
     * 文件id
     */
    private String fileId;


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

    public String getContractingUnit() {
        return contractingUnit;
    }

    public void setContractingUnit(String contractingUnit) {
        this.contractingUnit = contractingUnit;
    }

    public String getContractingCode() {
        return contractingCode;
    }

    public void setContractingCode(String contractingCode) {
        this.contractingCode = contractingCode;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
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

    public String getStakeNumber() {
        return stakeNumber;
    }

    public void setStakeNumber(String stakeNumber) {
        this.stakeNumber = stakeNumber;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getSupervisorUnit() {
        return supervisorUnit;
    }

    public void setSupervisorUnit(String supervisorUnit) {
        this.supervisorUnit = supervisorUnit;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

}

