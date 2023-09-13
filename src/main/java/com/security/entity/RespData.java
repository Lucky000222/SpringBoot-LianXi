package com.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.annotation.security.DenyAll;
import java.util.List;

@Data
public class RespData {
    private Long id;


    private String wbsId;

    // 项目名称
    private String projectName;

    // 标段名称
    private String sectionName;

    // 父级id
    private String parentId;

    // 开始桩号
    private String pileStart;

    // 结束桩号
    private String pileEnd;


    // 工程单元名称
    private String wbsName;

    // 开工报告的时间
    private String reportTime;

    private String num;

    private String type;

    private String projectTemplateId;



    @JsonIgnore
    private List<FormInstances> formInstancesList;

    // 工序报验第一个监理到场时间
    private String firstSupervisionTime;

    // 工序报验最后一个监理到场时间
    private String endSupervisionTime;

    //交工报告的第一个节点的监理到场时间
    private String firstCertificateTime;

    //交工报告最后一个节点的监理到场时间
    private String endCertificateTime;


    // 工序报验中工序之间的时间 用普通的字符串拼接
    private String nameAndDays;

    // 工序之间的时间 用json拼接，查询的时候转换成集合
    private String jsonNameAndDays;


    private Integer days;

    // 当前工程单元的公里数
    private Integer meter;



}
