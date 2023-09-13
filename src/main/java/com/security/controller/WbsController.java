package com.security.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.security.entity.RespData;
import com.security.entity.Wbs;
import com.security.service.WbsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * WBS工程结构表(Wbs)表控制层
 *
 * @author makejava
 * @since 2023-07-14 15:36:15
 */
@RestController
@RequestMapping("wbs")
public class  WbsController {
    /**
     * 服务对象
     */
    @Resource
    private WbsService wbsService;

/*
    项目表    builder_infra_dept_info   dept_id是项目id

    标段表   builder_unit_info   标段id是node_id     项目和标段找不到关联

    分部分项   wbs   id是实例id

    工序报验    form_instances      project_node_id 是关联wbs的实例id

    开工报告  workstage_work_report      node_id 是关联分项及以上的实例id

    交工证书  workstage_jg_certificate      node_id是 是关联wbs的实例id  （！！！找不到和工序关联的id）


    我们分析数据并对数据进行时间抽取，抽取六个时间，
    按照完工比例百分之百的数据进行抽取，
        1.开工报告的开始时间，                   取  分项开工报告时间
        2.工序报验的第一个节点的监理到场时间，      取工程单元的工序报验的  第一个施工放样的监理到场时间
        3.工序报验最后一个节点的监理到场时间，      取工程单元的工序报验的  最后一个节点的监理到场时间
        4.交工报告的第一个节点的监理到场时间，      取工程单元第一个交工证书的时间
        5.最后一个节点的监理到场时间，             取工程单元最后一个交工证书的时间
        6.以及工序报验中工序的之间的时间            取 工序和工序之间的时间 天数   存 [施工放样1，挖土2]，数组格式

采用wbs为主表
*/

    @GetMapping("/getTime")
    public String getTime(HttpServletResponse response) throws IOException {
        return wbsService.getTime1();



        /*ExcelWriter writer= ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("projectName","项目名称");
        writer.addHeaderAlias("sectionName","标段名称");
        writer.addHeaderAlias("wbsName","工程单元名称");
        writer.addHeaderAlias("reportTime","开工报告的时间");
        writer.addHeaderAlias("firstSupervisionTime","工序报验第一个监理到场时间");
        writer.addHeaderAlias("endSupervisionTime","工序报验最后一个监理到场时间");
        writer.addHeaderAlias("firstCertificateTime","交工报告的第一个节点的监理到场时间");
        writer.addHeaderAlias("endCertificateTime","交工报告最后一个节点的监理到场时间");
        writer.addHeaderAlias("nameAndDays","工序报验中工序的之间的时间, 0天代表是同一天开始和结束");
        //默认配置
        writer.write(time,true);
        //设置content—type
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset:utf-8");

        //设置标题
        String fileName= URLEncoder.encode("用户信息","UTF-8");
        //Content-disposition是MIME协议的扩展，MIME协议指示MIME用户代理如何显示附加的文件。
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");
        ServletOutputStream outputStream= response.getOutputStream();

        //将Writer刷新到OutPut
        writer.flush(outputStream,true);
        outputStream.close();
        writer.close();*/

//        return time;

    }

    @GetMapping("/getTime1")
    public String getTime1(HttpServletResponse response){
        return wbsService.getKilometres();
    }
    @GetMapping("/getMeterAndProcess")
    public String getMeterAndProcess(HttpServletResponse response){
        return wbsService.getMeterAndProcess();
    }

    // 根据code计算天数 和 米数  天数米数都是不为空的情况下 才会累加 然后除以不为空的数量 得出一个平均值  计算code和范本
    @GetMapping("export")
    public void export(){
        wbsService.export();
    }

    @GetMapping("getMeterAndProcessAndNull")
    public String getMeterAndProcessAndNull(){
        return wbsService.getMeterAndProcessAndNull();
    }

    // 计算code和工序
    @GetMapping("getCodeAndProcess")
    public String getCodeAndProcess(){
        return wbsService.getCodeAndProcess();
    }

    @GetMapping("getStr")
    public void getStr(){
        wbsService.getStr();
    }


}

