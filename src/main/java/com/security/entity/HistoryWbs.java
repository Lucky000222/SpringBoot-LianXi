package com.security.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

// 历史数据实体类
@Data
public class HistoryWbs {

    private String id;

    // 项目ID
    private String projectId;

    // 标段id
    private String sectionId;

    // WBS姓名
    private String wbsName;

    // 工程划分类型（1单位工程、2分部、子分部、3分项、子分项、4工序或计量单元）  4为工程单元 ！！！！
    private String divideType;

    // 结构类别（路面、路基、桥梁、隧道）
    private String structType;

    // 开始桩号
    private String startStake;

    // 结束桩号
    private String endStake;

    // 公里数  需要通过代码另外赋值的
    private Integer kilometre;

    /** 是否为叶子节点 */
    private Boolean isLeaf;

    // wbs关联清单   （通过wbs关联清单中间表 用wbsid查清单id去清单表查）
    //-----------------------------

    // wbs计量单位
//    private  String wbsMeterageUnit;

    // 工程内容
//    private String projectContent;

    // WBS关联清单表 合同总数
    private BigDecimal contractNumber;

    // WBS关联清单表 合同金额
    private BigDecimal checkAmount;

    // WBS清单表 价格总数
    private BigDecimal price;

    // WBS清单表 合同数量
    private BigDecimal listContractNumber;

    // 是否特殊项
//    private Integer isPecial;

    // 清单类型 （合同清单，临时清单，变更清单，材料清单）
//    private String listType;

    // 是否叶子节点
//    private Integer isLeaf;


    // wbs关联工序表   （通过工序id关联报验id 报验id查工序报验材料清单表）
    //-----------------------------

    // 工序计量单位
//    private String meterageUnit;  不需要

    // 清单数量
    private BigDecimal correctionNumber;

    // 核对数量
    private BigDecimal checkNumber;

    // 流程生效时间（开始时间）
    private Date effectTime;

    // 要求监理到场时间（结束时间）
    private Date arriveTime;

    // 3 材料清单
//    private Long meterageType;  不需要

    // wbs关联交工证书表 （wbs关联交工证书表id 交工id查交工计量清单表）
    //-----------------------------

    // 交工计量单位
//    private String meterageUnit;

    // 修编后数量
//    private BigDecimal correctionNumber; 不需要

    // 申报数量
    private BigDecimal applyNumber;

    // 核定数量
    private BigDecimal meterageCheckNumber;

    // 本次允许计量
    private BigDecimal currentAllowNumber;

    // 累积允许计量
    private BigDecimal allowNumber;

    // wbs关联开工报告表 （暂无）
    //-----------------------------

    // 需要通过代码另外赋值的
    // 施工天数
    private Integer days;

    // 天气
    private String weather;

    // 地形
    private String terrain;
}
