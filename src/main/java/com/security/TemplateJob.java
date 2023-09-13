package com.security;

import org.quartz.*;

import java.time.LocalDateTime;

public class TemplateJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//        System.out.println(context.getTrigger());
        System.err.println(LocalDateTime.now() + "  定时任务执行中:--------------------------------------------------------------           " );
        System.out.println(context.getJobDetail().getKey().getName());
    }
}
