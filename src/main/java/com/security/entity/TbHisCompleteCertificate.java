package com.security.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 交工证书(TbHisCompleteCertificate)实体类
 *
 * @author makejava
 * @since 2023-05-19 16:22:12
 */
public class TbHisCompleteCertificate implements Serializable {
    private static final long serialVersionUID = -76448298993697525L;
    /**
     * 主键
     */
    private String id;
    /**
     * 组织机构ID
     */
    private String orgId;
    /**
     * 分部分项id
     */
    private String wbsId;
    /**
     * 工程编号
     */
    private String wbsCode;
    /**
     * 长编码：标段.单位工程.分部.分项.工程单元
     */
    private String longWbsCode;
    /**
     * 工程名称
     */
    private String wbsName;
    /**
     * 工程全称
     */
    private String wbsFullName;
    /**
     * 证书编号
     */
    private String certificateCode;
    /**
     * 评定结果
     */
    private String result;
    /**
     * 得分
     */
    private String score;
    /**
     * 完成日期
     */
    private Date completeDate;
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
    private String segmentId;
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
     * 流程状态 1:未开始   2:进行中  3:已结束
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
     * 流程生效时间
     */
    private Date effectTime;
    /**
     * 承包单位名称
     */
    private String contractingUnit;
    /**
     * 监理单位
     */
    private String supervisorUnit;
    /**
     * 监理单位code
     */
    private String supervisorCode;
    /**
     * pdfId
     */
    private String pdfId;
    /**
     * 流程业务id
     */
    private String businessId;
    /**
     * 交工类型0:过程交工、1:最后交工，默认为空
     */
    private Integer type;


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

    public String getWbsFullName() {
        return wbsFullName;
    }

    public void setWbsFullName(String wbsFullName) {
        this.wbsFullName = wbsFullName;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
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

    public String getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(String segmentId) {
        this.segmentId = segmentId;
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

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
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

    public String getSupervisorCode() {
        return supervisorCode;
    }

    public void setSupervisorCode(String supervisorCode) {
        this.supervisorCode = supervisorCode;
    }

    public String getPdfId() {
        return pdfId;
    }

    public void setPdfId(String pdfId) {
        this.pdfId = pdfId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}

