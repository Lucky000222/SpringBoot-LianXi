package com.security.Quartz;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.quartz.*;
import org.quartz.ee.jmx.jboss.QuartzService;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Date;

import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzUtil {

    private static final SchedulerFactory SCHEDULER_FACTORY = new StdSchedulerFactory();

    @Autowired
    private QuartzService quartzService;

    /**
     * 添加一个定时任务
     *
     * @param name      任务名。每个任务唯一，不能重复。方便起见，触发器名也设为这个
     * @param group     任务分组。方便起见，触发器分组也设为这个
     * @param jobClass  任务的类类型  eg:TemplateJob.class
     * @param startTime 任务开始时间。传null就是立即开始
     * @param endTime   任务结束时间。如果是一次性任务或永久执行的任务就传null
     * @param cron      时间设置表达式。传null就是一次性任务
     */
    public static boolean addJob(String name, String group, Class<? extends Job> jobClass, String cron, JobDataMap jobDataMap) {
        try {
            // 第一步: 定义一个JobDetail
            JobDetail jobDetail = JobBuilder.newJob(jobClass).
                    withIdentity(name, group).build();
//            withIdentity(name, group).setJobData(jobDataMap).build();
            // 第二步: 设置触发器
            TriggerBuilder<Trigger> triggerBuilder = newTrigger();
            triggerBuilder.withIdentity(name, group);

            triggerBuilder.startAt(new Date());
            triggerBuilder.endAt(null); //设为null则表示不会停止

            if (StrUtil.isNotEmpty(cron)) {
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            }
            Trigger trigger = triggerBuilder.build();
            //第三步：调度器设置
            Scheduler scheduler = SCHEDULER_FACTORY.getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // 修改定时任务
    public static boolean modifyJobTime(String name, String group, LocalDateTime newStartTime,
                                        LocalDateTime newEndTime, String cron) {
        try {
            Scheduler scheduler = SCHEDULER_FACTORY.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(name, group);
            Trigger oldTrigger = scheduler.getTrigger(triggerKey);
            if (oldTrigger == null) {
                return false;
            }
            TriggerBuilder<Trigger> triggerBuilder = newTrigger();
            triggerBuilder.withIdentity(name, group);
            if (newStartTime != null) {
                triggerBuilder.startAt(toStartDate(newStartTime));   // 任务开始时间设定
            } else if (oldTrigger.getStartTime() != null) {
                triggerBuilder.startAt(oldTrigger.getStartTime()); //没有传入新的开始时间就不变
            }
          /*  if (newEndTime != null) {
                triggerBuilder.endAt(toEndDate(newEndTime));   // 任务结束时间设定
            } else if (oldTrigger.getEndTime() != null) {
                triggerBuilder.endAt(oldTrigger.getEndTime()); //没有传入新的结束时间就不变
            }*/
            if (StrUtil.isNotEmpty(cron)) {
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            } else if (oldTrigger instanceof CronTrigger) {
                String oldCron = ((CronTrigger) oldTrigger).getCronExpression();
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(oldCron));
            }
            Trigger newTrigger = triggerBuilder.build();
            scheduler.rescheduleJob(triggerKey, newTrigger);    // 修改触发时间
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static Date toEndDate(LocalDateTime endDateTime) {
        // 结束时间可以为null，所以endDateTime为null，直接返回null即可
        return endDateTime != null ?
                DateUtil.date(endDateTime) : null;
    }

    private static Date toStartDate(LocalDateTime startDateTime) {
        // startDateTime为空时返回当前时间，表示立即开始
        return startDateTime != null ? DateUtil.date(startDateTime) : new Date();
    }

}

