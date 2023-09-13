package com.security.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbTableSheet)实体类
 */
@Data
public class TbTableSheet implements Serializable {
    private static final long serialVersionUID = 1;
    
    private Long id;
    /**
     * 项目id
     */
    private String projectId;
    /**
     * 表格的json数据
     */
    private String sheetData;
    /**
     * 0为源表，1为项目表
     */
    private String type;
    /**
     * 创建时间
     */
    private Date createTime;



}

