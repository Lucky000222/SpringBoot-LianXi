package com.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * WBS工程结构表(Wbs)实体类
 *
 * @author makejava
 * @since 2023-07-14 15:36:15
 */

@Data
public class Wbs implements Serializable {
    private static final long serialVersionUID = -80882481215856503L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 企业id
     */
    private Integer epid;
    /**
     * 父节点ID
     */
    private String parentId;
    /**
     * 项目ID
     */
    private String projectId;
    /**
     * 标段ID
     */
    private String sectionId;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 编号
     */
    private String num;
    /**
     * 类型（1：标段，0：单位工程，2：分部工程，4：分项工程、5：子分项（工程单元））
     */
    private String type;
    /**
     * 来源分类（-1：默认，0：通用，1：质检，2：计量）
     */
    private Integer sourceType;
    /**
     * 形象进度类型（1-17）
     */
    private Integer visualScheduleType;
    /**
     * 属性类型，默认0（1：路基；2：路面；3：桥梁；4：隧道；5：绿化；6：声屏障；7：交安；8：线外；11：机电；）
     */
    private Integer wbsProperty;
    /**
     * 属性值，例如隧道米数
     */
    private String wbsPropertyValue;
    /**
     * 开始桩号
     */
    private String pileStart;
    /**
     * 结束桩号
     */
    private String pileEnd;
    /**
     * 排序号
     */
    private Integer sort;
    /**
     * 工程模板id
     */
    private String projectTemplateId;
    /**
     * 是否重点工程，0否1是
     */
    private Integer isFocus;
    /**
     * 是否制约工程，0否1是
     */
    private Integer isRestrict;
    /**
     * 软删除标志位，0：未删除，1：删除
     */
    private Integer isDelete;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 修改时间
     */
    private Date updateAt;
    /**
     * 修改人
     */
    private String updateBy;
    /**
     * 挂接清单总价
     */
    private Double inventoryTotalPrice;
    /**
     * 挂接清单总数量
     */
    private Double inventoryTotalNumber;
    /**
     * 中心桩号
     */
    private String pileCenter;
    /**
     * 路基-> 资产名称,挂在分部分项工程单元上 0:主线,1:互通,2:枢纽,3:互通链接线\r\n
     */
    private String subgradeName;
    /**
     * 路基 ->互通形式 0:苜蓿叶
     */
    private String interWorkingForm;
    /**
     * WBS路径id
     */
    private String pathId;
    
    private String path;
    /**
     * wbs状态，1：已拆分；2：已核查
     */
    private Integer wbsStatus;
    /**
     * 大类，0-3：主线，互通，枢纽，连接线
     */
    private Integer wbsBigCategory;
    /**
     * 中类，1-4：超大桥、超长隧道，大桥、长隧道，中桥、中隧道，小桥、短隧道
     */
    private Integer wbsMidCategory;
    /**
     * 小类，1-3：普通桥梁，互通立交，分离立交
     */
    private Integer wbsSmallCategory;
    /**
     * 是否工序报验
     */
    private Integer inspectStatus;
    /**
     * 是否交工
     */
    private Integer jgStatus;

    @JsonIgnore
    private List<FormInstances> formInstancesList;

    private Integer meter;


}

