package com.security.common;

import lombok.Data;

import java.io.Serializable;

/**
 * (GongchengCopy1Copy2Copy6)实体类
 *
 * @author 
 * @since 2022-12-28 15:10:31
 */
@Data
public class GongCheng implements Serializable {
    private static final long serialVersionUID = 241964697080076978L;
    
    private Object id;
    /**
     * 工程名字
     */
    private Object name;
    /**
     * 最早开始时间
     */
    private Object zuiZaoStart;
    /**
     * 最早完成时间
     */
    private Object zuiZaoFinish;
    /**
     * 最晚开始
     */
    private Object zuiWanStart;
    /**
     * 最晚结束
     */
    private Object zuiWanFinish;
    /**
     * 所需天数
     */
    private Object shicha;
    /**
     * 上级范本编号
     */
    private Object superiorNo;
    /**
     * 范本编号
     */
    private Object modelNo;
    /**
     * 天气
     */
    private Object weather;
    /**
     * 地形
     */
    private Object dixing;


    private Object shichaPredictvalue;



}

