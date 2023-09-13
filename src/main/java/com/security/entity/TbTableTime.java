package com.security.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbTableTime)实体类
 *
 * @author makejava
 * @since 2023-06-21 15:34:29
 */
@Data
public class TbTableTime implements Serializable {
    private static final long serialVersionUID = 186129718836974893L;
    
    private Long id;
    /**
     * 定时任务的执行时间，用于重启项目后，设置的时间丢失，到数据库里获取上一次设置的时间，再赋值进去
     */
    private String saveTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 项目id/任务名
     */
    private String projectId;
    /**
     * cron表达式
     */
    private String cron;



}

