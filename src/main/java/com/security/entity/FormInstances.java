package com.security.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 表单实例(FormInstances)实体类
 *
 * @author makejava
 * @since 2023-07-17 10:08:02
 */
@Data
public class FormInstances implements Serializable {
    private static final long serialVersionUID = -61899123956797980L;
    
    private Long id;
    /**
     * 企业租户id
     */
    private Integer tenantId;
    /**
     * 创建人用户名
     */
    private String createdBy;
    /**
     * 创建日期
     */
    private Date createdDate;
    /**
     * 修改人用户名
     */
    private String lastModifiedBy;
    /**
     * 最后修改日期
     */
    private Date lastModifiedDate;
    /**
     * 版本号
     */
    private Long version;
    /**
     * 本次产值
     */
    private Double amount;
    /**
     * 锁定人
     */
    private String claimer;
    /**
     * 模板分类
     */
    private String classifier;
    /**
     * 截止日期
     */
    private Date deadline;
    /**
     * 关联表单实例id
     */
    private String formId;
    /**
     * 表单实例名称
     */
    private String name;
    /**
     * 本次占比
     */
    private String percent;
    /**
     * 部位
     */
    private String position;
    /**
     * 关联流程实例id
     */
    private String processInstanceId;
    /**
     * 项目id
     */
    private String projectId;
    /**
     * 工程节点id
     */
    private String projectNodeId;
    /**
     * 是否合格
     */
    private Integer qualified;
    /**
     * 标段id
     */
    private String sectionId;
    /**
     * 发起日期
     */
    private Date startDate;
    /**
     * 发起人
     */
    private String starter;
    /**
     * 流程状态(0未发起，1审批中，2退回，3完成)
     */
    private Integer status;
    /**
     * 监理到场时间
     */
    private String supervisionTime;
    /**
     * 模板库id
     */
    private Integer templateDbId;
    /**
     * 模板库名称
     */
    private String templateDbName;
    /**
     * 模板id
     */
    private String templateId;
    /**
     * 模板名称
     */
    private String templateName;
    /**
     * 工程单元总产值
     */
    private Double totalAmount;
    /**
     * 模板类型：1.记录表 2.交验用表 3.测表 4.检表 5.分项评定表 6.分部评定表 7.单位评定表 8.监表 9.日志
     */
    private Integer type;
    
    private Long weight;
    /**
     * 工序id
     */
    private String workStageId;
    /**
     * 表单文件id
     */
    private Long documentId;
    /**
     * 工序名称
     */
    private String workStageName;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 标段名称
     */
    private String sectionName;
    /**
     * 工程节点名称
     */
    private String projectNodeName;
    /**
     * 结束日期
     */
    private Date endDate;
    /**
     * 累计产值
     */
    private Double subItemAmount;
    /**
     * 工序产值
     */
    private Double workStageAmount;
    /**
     * 工序占比
     */
    private Integer workStagePercent;
    
    private Integer attachmentSize;
    /**
     * 是否延续
     */
    private Integer ifContinue;
    /**
     * 编码
     */
    private String code;
    /**
     * 工程单元占比
     */
    private Double totalPercent;
    /**
     * 审批意见
     */
    private String approveRemark;
    /**
     * 下一步审批人
     */
    private String audioPerson;
    /**
     * 工序部位id
     */
    private String wbsWorkstagePositionId;
    /**
     * 工序报验影像补齐人用户名
     */
    private String attachUpdateBy;
    /**
     * 工序报验影像补齐时间
     */
    private Date attachUpdateAt;
    /**
     * 质量证明附件
     */
    private String qualityProveRemark;

}

