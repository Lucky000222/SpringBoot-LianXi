package com.security.controller;

//import com.security.config.ScheduleTask;

import com.security.Quartz.QuartzUtil;
import com.security.TemplateJob;
import com.security.entity.TbTableTime;
import com.security.service.TbTableTimeService;
import com.security.utils.CornUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController()
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
//    private final ScheduleTask scheduleTask;

//    @Autowired
//    private FormInstances1Service formInstances1Service;

    @Autowired
    private TbTableTimeService tbTableTimeService;

    @GetMapping("/updateCron")
    public String updateCron(String cron) {
//        cron = "0/30 * * * * ?";
//        0 0 1 * * ?
//        scheduleTask.setCron(cron);
        System.out.println("重置定时任务成功-----------------" + LocalDateTime.now());
        return "ok";
    }

//    @GetMapping("/get")
//    public TbTableTime formInstances1Service() {
//        return formInstances1Service.selectTableTime();
//    }

    //// [秒] [分] [小时] [日] [月] [周] [年]

    // TODO 实时报表的定时任务是否能灵活选择几天后什么时候进行定时更新
    // 假如现在是 2023-08-15 10:24:30
    // 前端选择了 2023-08-17 11:30:00
    // 减去这个时间后 计算几天
    // TODO 添加定时任务
    @GetMapping("/addQuartz")
    public String addQuartz(String projecyId, String time, String day) {
        String cron = CornUtil.StringToCron(time, day);
        System.err.println("--------------------" + cron + "--------------------");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TbTableTime tableTime = tbTableTimeService.selectByProjectId(projecyId);
        if (tableTime != null) {
            throw new RuntimeException("定时任务已存在");
        }
        // 0/10 * * * * ?
        boolean b = QuartzUtil.addJob(projecyId, "ShiShiBaoBiao", TemplateJob.class, cron, null);
        if (b) {
            TbTableTime tbTableTime = new TbTableTime();
            tbTableTime.setProjectId(projecyId);
            tbTableTime.setCron(cron);
            tbTableTime.setCreateTime(new Date());
            tbTableTime.setSaveTime(time);
            tbTableTimeService.insert(tbTableTime);
            return "定时任务添加成功" + sdf.format(new Date());
        } else {
            return "定时任务添加失败";
        }
    }


    @GetMapping("/addQuartz2")
    public String addQuartz2(String projecyId, String time, String day) {
//        String cron = CornUtil.StringToCron(time, day);
        String cron = "0 */1 * * * ?";
        System.err.println("--------------------" + cron + "--------------------");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TbTableTime tableTime = tbTableTimeService.selectByProjectId(projecyId);
        if (tableTime != null) {
            throw new RuntimeException("定时任务已存在");
        }
        // 0/10 * * * * ?
        boolean b = QuartzUtil.addJob(projecyId, "ShiShiBaoBiao", TemplateJob.class, cron, null);
        if (b) {
            TbTableTime tbTableTime = new TbTableTime();
            tbTableTime.setProjectId(projecyId);
            tbTableTime.setCron(cron);
            tbTableTime.setCreateTime(new Date());
            tbTableTime.setSaveTime(time);
            tbTableTimeService.insert(tbTableTime);
            return "定时任务添加成功" + sdf.format(new Date());
        } else {
            return "定时任务添加失败";
        }
    }
    // TODO 修改定时任务
    @GetMapping("/modifyQuartz")
    public boolean modifyQuartz(String projecyId, String time, String day) {
        String cron = CornUtil.StringToCron(time, day);
        TbTableTime tbTableTime = tbTableTimeService.selectByProjectId(projecyId);
        boolean b = false;
        if (tbTableTime != null){
            b = QuartzUtil.modifyJobTime(projecyId, "ShiShiBaoBiao", null, null, cron);
            if (b){
                tbTableTime.setSaveTime(time);
                tbTableTime.setCron(cron);
                tbTableTimeService.update(tbTableTime);
            }
        }
        return b;
    }

    @GetMapping("/insertAll")
    public boolean insertAll() {
        long timeMillis = System.currentTimeMillis();
        List<TbTableTime>  list = new ArrayList<>();
        for (int i = 0; i < 55000; i++) {
            TbTableTime tableTime = new TbTableTime();
            tableTime.setSaveTime(i+"");
            tableTime.setCron(i+"");
            tableTime.setProjectId(i+"");
            tableTime.setCreateTime(new Date());
            list.add(tableTime);
        }
        int i = tbTableTimeService.insertBatch(list);
        System.out.println(System.currentTimeMillis() - timeMillis);
        return i > 1;
    }
}
