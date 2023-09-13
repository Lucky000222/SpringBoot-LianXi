package com.security.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * WBS计划(JdPlanWbs)实体类
 *
 * @author 
 * @since 2023-02-28 09:31:57
 */
@Data
public class JdPlanWbs implements Serializable {
    private static final long serialVersionUID = -11090441539327347L;
    /**
     * 主键
     */
    private String id ;
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
     * 标段编码(CODE)
     */
    private String sectionCode;
    /**
     * WBS实例(ID)
     */
    private String wbsInstanceId;
    /**
     * 版本ID
     */
    private String versionId;
    /**
     * 编号
     */
    private String wbsCode;
    /**
     * 名称
     */
    private String wbsName;
    /**
     * 工程划分类型（单位工程、分部、子分部、分项、子分项、工序或计量单元）
     */
    private String divideType;
    /**
     * 路面、路基、桥梁、隧道
     */
    private String structType;
    /**
     * 计划开工日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    /**
     * 计划完工日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    /**
     * 实际开工日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date realStartDate;
    /**
     * 实际完工日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date realEndDate;
    /**
     * 计划产值
     */
    private Double outputValue;
    /**
     * 实际产值
     */
    private Double realOutputValue;
    /**
     * 进度
     */
    private String process;
    /**
     * 负责人
     */
    private String chargePerson;
    /**
     * 状态
     */
    private String status;
    /**
     * 是否里程碑
     */
    private String isMilestone;
    /**
     * 是否关联分部分项
     */
    private String isRelevance;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")

    private Date createTime;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
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
    private Long isLeaf;
    /**
     * 负责人id
     */
    private String chargePersonId;

}

