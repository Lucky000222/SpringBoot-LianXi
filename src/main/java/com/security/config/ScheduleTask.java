/*
package com.security.config;

import com.security.dao.FormInstances1Dao;
import com.security.entity.TbTableTime;
import com.security.service.FormInstances1Service;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Slf4j
@Component
@PropertySource("classpath:/task-config.ini")
public class ScheduleTask implements SchedulingConfigurer {

    @Value("${scheduleTime.cron}")
    private String cron;

    @Autowired
    private FormInstances1Service formInstances1Service;


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        // 动态使用cron表达式设置循环间隔
        taskRegistrar.addTriggerTask(
                () -> {
                    log.info("first->Current time： {}", LocalDateTime.now());

//                    TbTableTime tbTableTime = formInstances1Service.selectTableTime();
//                    if (tbTableTime.getSaveTime() != null){
//                        cron = "0/30 * * * * ?";
//                    }
                    if (!cron.equals("0/60 * * * * ?")){
                        System.out.println("触发定时任务 first->Current time： {}   " +  LocalDateTime.now());
                        try {
                            formInstances1Service.copyFile();
                        } catch (IOException | ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                triggerContext -> {

                    // 使用CronTrigger触发器，可动态修改cron表达式来操作循环规则
                    CronTrigger cronTrigger = new CronTrigger(cron);
                    Date nextExecutionTime = cronTrigger.nextExecutionTime(triggerContext);
                    return nextExecutionTime;
                });
    }




}*/
