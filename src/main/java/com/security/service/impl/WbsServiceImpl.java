package com.security.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.security.entity.*;
import com.security.dao.WbsDao;
import com.security.service.WbsService;
import com.security.utils.BatchInsertMethodUtil;
import com.security.utils.CalculationUtil;
import com.security.utils.DaysUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * WBS工程结构表(Wbs)表服务实现类
 *
 * @author makejava
 * @since 2023-07-14 15:36:15
 */
@Service
public class WbsServiceImpl implements WbsService {
    @Resource
    private WbsDao wbsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Wbs queryById(String id) {
        return this.wbsDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param wbs         筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Wbs> queryByPage(Wbs wbs, PageRequest pageRequest) {
        long total = this.wbsDao.count(wbs);
        return new PageImpl<>(this.wbsDao.queryAllByLimit(wbs, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param wbs 实例对象
     * @return 实例对象
     */
    @Override
    public Wbs insert(Wbs wbs) {
        this.wbsDao.insert(wbs);
        return wbs;
    }

    /**
     * 修改数据
     *
     * @param wbs 实例对象
     * @return 实例对象
     */
    @Override
    public Wbs update(Wbs wbs) {
        this.wbsDao.update(wbs);
        return this.queryById(wbs.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.wbsDao.deleteById(id) > 0;
    }

    @Autowired
    private BatchInsertMethodUtil batchInsertMethodUtil;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    // TODO 工序之间的时间 用普通字符串拼接的方式
    @Override
    public String getTime() {
        // 这个项目id 查询到的wbs数量
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 这个项目id 实际统计的wbs数量
        HashMap<String, Integer> map = new HashMap<>();

        List<RespData> respDataList = new ArrayList<>();
        List<String> list1 = wbsDao.selectProjectIds();
        for (String projectId : list1) {
            List<String> sectionIdList = wbsDao.selectSectionIds(projectId);
            List<RespData> respData1 = wbsDao.selectWbsDetailTime(sectionIdList);
            for (RespData respData : respData1) {
                hashMap.put(projectId, respData1.size());
                List<FormInstances> formInstancesList = respData.getFormInstancesList();
                boolean b = true;
                int num = 0;
                for (FormInstances formInstances : formInstancesList) {
                    num++;
                    // 遍历该工程单元所有的工序报验 必须都为已完成并且有两条数据以上才算 100%已完成
                    // （两条以上）去页面上看的时候，如果只有一条工序报验是已完成，它的进度是0%
                    if (formInstances.getStatus() != 3) {
                        b = false;
                    }
                }
                if (b && num > 1) {
                    int size = formInstancesList.size();
                    StringBuilder sb = new StringBuilder();
                    if (size > 1) {
                        // 工序报验第一个监理到场时间
                        FormInstances instances1 = formInstancesList.get(0);
                        respData.setFirstSupervisionTime(instances1.getSupervisionTime());
                        // 工序报验最后一个监理到场时间
                        FormInstances instances2 = formInstancesList.get(size - 1);
                        respData.setEndSupervisionTime(instances2.getSupervisionTime());
                        try {
                            int days = DaysUtil.Days(instances1.getSupervisionTime(), instances2.getSupervisionTime());
                            respData.setDays(days);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }

                        for (int i = 0; i < size; i++) {
                            if (i == size - 1) {
                                break;
                            }
                            try {
                                FormInstances formInstances1 = formInstancesList.get(i);
                                FormInstances formInstances2 = formInstancesList.get(i + 1);
                                int days = DaysUtil.Days(formInstances1.getSupervisionTime(), formInstances2.getSupervisionTime());
                                sb.append(formInstances1.getWorkStageName()).append("---").append(formInstances2.getWorkStageName()).append(" : ").append(days).append("天, ");
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }

                        }
                        // 以及工序报验中工序的之间的时间
                        respData.setNameAndDays(sb.substring(0, sb.length() - 1));

                        StringBuilder str = new StringBuilder();
                        List<String> strList = new ArrayList<>();
                        String parentId = respData.getParentId();
                        for (int i = 3; i > 0; i--) {
                            if (parentId != null) {
                                FuYuZi fu = wbsDao.getFU(parentId);
                                if (fu != null) {
                                    if (fu.getNum() != null) {
//                                        str = str + i + ":" + fu.getNum() + "-";
                                        strList.add(fu.getNum());
                                        parentId = fu.getParentId();
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (strList.size() > 0) {
                            Collections.reverse(strList);
                            for (String s : strList) {
                                str.append(s).append("-");
                            }
                            respData.setNum(str.substring(0, str.length() - 1));
                        }
                    } else if (size == 1) {
                        FormInstances formInstances = formInstancesList.get(0);
                        String supervisionTime = formInstances.getSupervisionTime();
                        // 工序报验第一个监理到场时间
                        respData.setFirstSupervisionTime(supervisionTime);
                        // 工序报验最后一个监理到场时间
                        respData.setEndSupervisionTime(supervisionTime);
                        respData.setNameAndDays(formInstances.getName() + " : " + supervisionTime);
                    }
                    List<String> list = wbsDao.selectWorkstageWorkReport(respData.getParentId());
                    if (list != null && list.size() > 0) {
                        respData.setReportTime(list.get(0));
                    }
                    respDataList.add(respData);

//                    wbsDao.insertTime(respData);
                }
            }
            map.put(projectId, respDataList.size());
        }
/*        try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false)) {
            //6.获取mapper
            WbsDao mapper = sqlSession.getMapper(WbsDao.class);
            //7.循环添加
            respDataList.forEach(mapper::insertTime);
            //8.提交事务,清除缓存
            sqlSession.commit();
            sqlSession.clearCache();
        }*/
        batchInsertMethodUtil.batchUpdateOrInsert(respDataList, WbsDao.class, (item, mapper) -> mapper.insertTime(item));
        System.out.println(new Date());


        System.err.println(hashMap);
        System.err.println("----------------------------------------------------------------------------");
        System.err.println(map);

        return "添加成功";
    }

    // TODO 工序之间的时间 用json拼接，查询的时候转换成集合
    @Override
    public String getTime1() {
        // 这个项目id 查询到的wbs数量
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 这个项目id 实际统计的wbs数量
        HashMap<String, Integer> map = new HashMap<>();

        List<RespData> respDataList = new ArrayList<>();
        List<String> list1 = wbsDao.selectProjectIds();
        for (String projectId : list1) {
            List<String> sectionIdList = wbsDao.selectSectionIds(projectId);
            List<RespData> respData1 = wbsDao.selectWbsDetailTime(sectionIdList);
            for (RespData respData : respData1) {
                hashMap.put(projectId, respData1.size());
                List<FormInstances> formInstancesList = respData.getFormInstancesList();
                boolean b = true;
                int num = 0;
                for (FormInstances formInstances : formInstancesList) {
                    num++;
                    // 遍历该工程单元所有的工序报验 必须都为已完成并且有两条数据以上才算 100%已完成
                    // （两条以上）去页面上看的时候，如果只有一条工序报验是已完成，它的进度是0%
                    if (formInstances.getStatus() != 3) {
                        b = false;
                    }
                }
                if (b && num > 1) {
                    int size = formInstancesList.size();
                    StringBuilder sb = new StringBuilder();
                    if (size > 1) {
                        // 工序报验第一个监理到场时间
                        FormInstances instances1 = formInstancesList.get(0);
                        respData.setFirstSupervisionTime(instances1.getSupervisionTime());
                        // 工序报验最后一个监理到场时间
                        FormInstances instances2 = formInstancesList.get(size - 1);
                        respData.setEndSupervisionTime(instances2.getSupervisionTime());
                        try {
                            int days = DaysUtil.Days(instances1.getSupervisionTime(), instances2.getSupervisionTime());
                            respData.setDays(days);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }

                        List<ProcessDetail> processDetailList = new ArrayList<>();
                        for (int i = 0; i < size; i++) {
                            if (i == size - 1) {
                                break;
                            }
                            if (i == 0) {
                                FormInstances formInstances = formInstancesList.get(i);
                                ProcessDetail processDetail = new ProcessDetail();
                                processDetail.setProcessName(formInstances.getWorkStageName());
                                processDetail.setDays(0);
                                processDetailList.add(processDetail);
                            } else {
                                try {
                                    FormInstances formInstances1 = formInstancesList.get(i - 1);
                                    FormInstances formInstances2 = formInstancesList.get(i);
                                    int days = DaysUtil.Days(formInstances1.getSupervisionTime(), formInstances2.getSupervisionTime());
                                    ProcessDetail processDetail = new ProcessDetail();
                                    processDetail.setProcessName(formInstances2.getWorkStageName());
                                    processDetail.setDays(days);
                                    processDetailList.add(processDetail);
                                } catch (ParseException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                            try {
                                FormInstances formInstances1 = formInstancesList.get(i);
                                FormInstances formInstances2 = formInstancesList.get(i + 1);
                                int days = DaysUtil.Days(formInstances1.getSupervisionTime(), formInstances2.getSupervisionTime());
                                sb.append(formInstances1.getWorkStageName()).append("---").append(formInstances2.getWorkStageName()).append(" : ").append(days).append("天, ");
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        // 以及工序报验中工序的之间的时间 普通字符串
                        respData.setNameAndDays(sb.substring(0, sb.length() - 1));

                        String jsonString = JSON.toJSONString(processDetailList, SerializerFeature.WRITE_MAP_NULL_FEATURES);
                        // 以及工序报验中工序的之间的时间  用json拼接，查询的时候转换成集合
                        respData.setJsonNameAndDays(jsonString);

                        // 设置code
                        StringBuilder str = new StringBuilder();
                        List<String> strList = new ArrayList<>();
                        String parentId = respData.getParentId();
                        for (int i = 3; i > 0; i--) {
                            if (parentId != null) {
                                FuYuZi fu = wbsDao.getFU(parentId);
                                if (fu != null) {
                                    if (fu.getNum() != null) {
//                                        str = str + i + ":" + fu.getNum() + "-";
                                        strList.add(fu.getNum());
                                        parentId = fu.getParentId();
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (strList.size() > 0) {
                            Collections.reverse(strList);
                            for (String s : strList) {
                                str.append(s).append("-");
                            }
                            respData.setNum(str.substring(0, str.length() - 1));
                        }
                    } else if (size == 1) {
                        FormInstances formInstances = formInstancesList.get(0);
                        String supervisionTime = formInstances.getSupervisionTime();
                        // 工序报验第一个监理到场时间
                        respData.setFirstSupervisionTime(supervisionTime);
                        // 工序报验最后一个监理到场时间
                        respData.setEndSupervisionTime(supervisionTime);
                        respData.setNameAndDays(formInstances.getName() + " : " + supervisionTime);
                    }
                    List<String> list = wbsDao.selectWorkstageWorkReport(respData.getParentId());
                    if (list != null && list.size() > 0) {
                        respData.setReportTime(list.get(0));
                    }
                    respDataList.add(respData);

//                    wbsDao.insertTime(respData);
                }
            }
            map.put(projectId, respDataList.size());
        }
        batchInsertMethodUtil.batchUpdateOrInsert(respDataList, WbsDao.class, (item, mapper) -> mapper.insertTimeForJson(item));
        System.out.println(new Date());


        System.err.println(hashMap);
        System.err.println("----------------------------------------------------------------------------");
        System.err.println(map);

        return "添加成功";
    }

    // 计算桩号公里数和天数  然后计算一天多少公里数
    @Override
    public String getKilometres() {
        int count1 = 0;
        int count2 = 0;

        // 2023-09-05 11:56:21.043
        // wbs查询完成Tue Sep 05 12:02:31 CST 2023
        // 用collection查询时间久一点 需要6分钟
        List<Wbs> wbs1 = wbsDao.queryAllWbs();
        System.err.println("wbs查询完成" + new Date());
        List<Wbs> wbs2 = new ArrayList<>();

        HashMap<String, List<FormInstances>> hashMap = new HashMap<>();
        List<FormInstances> formInstances4 = wbsDao.selectFormInstancesAll();
        System.err.println("工序查询完成" + new Date());

        for (FormInstances formInstances : formInstances4) {
            if (hashMap.get(formInstances.getProjectNodeId()) != null){
                List<FormInstances> formInstances1 = hashMap.get(formInstances.getProjectNodeId());
                formInstances1.add(formInstances);
                hashMap.put(formInstances.getProjectNodeId(), formInstances1);
            }else {
                List<FormInstances> formInstances5 = new ArrayList<>();
                formInstances5.add(formInstances);
                hashMap.put(formInstances.getProjectNodeId(), formInstances5);
            }
        }

        System.err.println("工序处理完成" + new Date());
        System.err.println("工序的长度" + hashMap.size());

        for (Wbs wbs : wbs1) {
            count1++;
            System.out.println("外面的第 "+count1 + "次");
            List<FormInstances> formInstances3 = hashMap.get(wbs.getId());
            if (formInstances3 != null && formInstances3.size() > 0) {
                // 1.当开始桩号和结束桩号都不为空的时候
                if (!"".equals(wbs.getPileStart()) && wbs.getPileStart() != null) {
                    if (!"".equals(wbs.getPileEnd()) && wbs.getPileEnd() != null) {
                        count2++;
                        System.err.println("里面的第 "+count2 + "次");
                        //  2.就计算当前wbs的公里数是多少
                        List<Integer> startList = CalculationUtil.extractDigit(wbs.getPileStart());
                        List<Integer> endList = CalculationUtil.extractDigit(wbs.getPileEnd());
                        if (startList.size() > 0 && endList.size() > 0){
                            Integer meter = CalculationUtil.compute(startList, endList);
                            formInstances3.sort(Comparator.comparing(FormInstances::getSupervisionTime));
//                        formInstancesList.sort(((o1, o2) -> Integer.compare(o1.getSupervisionTime(), o2.getSupervisionTime())));

                            double day = 0;
                            boolean b = true;
                            int num = 0;
                            for (FormInstances formInstances : formInstances3) {
                                num++;
                                // 遍历该工程单元所有的工序报验 必须都为已完成并且有两条数据以上才算 100%已完成
                                // （两条以上）去页面上看的时候，如果只有一条工序报验是已完成，它的进度是0%
                                if (formInstances.getStatus() != 3) {
                                    b = false;
                                }
                            }
                            if (b && num > 1) {
                                FormInstances formInstances1 = formInstances3.get(0);
                                FormInstances formInstances2 = formInstances3.get(formInstances3.size() - 1);
                                try {
                                    day = DaysUtil.Days(formInstances1.getSupervisionTime(), formInstances2.getSupervisionTime());
                                    if (day == 0){
                                        day = 1;
                                    }
                                } catch (ParseException e) {
                                    throw new RuntimeException(e);
                                }
                                // 得出每天多少公里数
                                double augForDay = meter / day;
                                wbs.setMeter((int)Math.ceil(augForDay));
                                wbs2.add(wbs);
                            }
                        }
                    }
                }
            }
        }
        batchInsertMethodUtil.batchUpdateOrInsert(wbs2, WbsDao.class, (item, mapper) -> mapper.insertWbs1(item));
        return "操作成功";
    }

    // 计算每天米数 总共的天数 对应每个的工序天数
    @Override
    public String getMeterAndProcess() {
        List<RespData> respDataList = new ArrayList<>();

        List<RespData> wbsRespData = wbsDao.queryAllWbsRespData();
        System.err.println("wbs查询完成" + new Date() + "  , 长度为: " + wbsRespData.size());

        HashMap<String, List<FormInstances>> hashMap = new HashMap<>();
        List<FormInstances> formInstances4 = wbsDao.selectFormInstancesAll();
        System.err.println("工序查询完成" + new Date());

        for (FormInstances formInstances : formInstances4) {
            if (hashMap.get(formInstances.getProjectNodeId()) != null){
                List<FormInstances> formInstances1 = hashMap.get(formInstances.getProjectNodeId());
                formInstances1.add(formInstances);
                hashMap.put(formInstances.getProjectNodeId(), formInstances1);
            }else {
                List<FormInstances> formInstances5 = new ArrayList<>();
                formInstances5.add(formInstances);
                hashMap.put(formInstances.getProjectNodeId(), formInstances5);
            }
        }

            for (RespData respData : wbsRespData) {
                List<FormInstances> formInstancesList = hashMap.get(respData.getWbsId());
                if (formInstancesList != null && formInstancesList.size() > 0){
                    boolean b = true;
                    int num = 0;
                    for (FormInstances formInstances : formInstancesList) {
                        num++;
                        // 遍历该工程单元所有的工序报验 必须都为已完成并且有两条数据以上才算 100%已完成
                        // （两条以上）去页面上看的时候，如果只有一条工序报验是已完成，它的进度是0%
                        if (formInstances.getStatus() != 3) {
                            b = false;
                        }
                    }
                    if (b && num > 1 && !"".equals(respData.getPileEnd()) && respData.getPileEnd() != null
                            && !"".equals(respData.getPileStart()) && respData.getPileStart() != null) {
                        // 设置一天多少米数
                        Integer meter = getMeter(respData, formInstancesList);
                        respData.setMeter(meter);

                        int size = formInstancesList.size();
                        StringBuilder sb = new StringBuilder();
                        if (size > 1) {
                            // 工序报验第一个监理到场时间
                            FormInstances instances1 = formInstancesList.get(0);
                            respData.setFirstSupervisionTime(instances1.getSupervisionTime());
                            // 工序报验最后一个监理到场时间
                            FormInstances instances2 = formInstancesList.get(size - 1);
                            respData.setEndSupervisionTime(instances2.getSupervisionTime());
                            try {
                                int days = DaysUtil.Days(instances1.getSupervisionTime(), instances2.getSupervisionTime());
                                respData.setDays(days);
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }

                            List<ProcessDetail> processDetailList = new ArrayList<>();
                            for (int i = 0; i < size; i++) {
                                if (i == 0) {
                                    FormInstances formInstances = formInstancesList.get(i);
                                    ProcessDetail processDetail = new ProcessDetail();
                                    processDetail.setProcessName(formInstances.getWorkStageName());
                                    processDetail.setDays(0);
                                    processDetailList.add(processDetail);
                                } else {
                                    try {
                                        FormInstances formInstances1 = formInstancesList.get(i - 1);
                                        FormInstances formInstances2 = formInstancesList.get(i);
                                        int days = DaysUtil.Days(formInstances1.getSupervisionTime(), formInstances2.getSupervisionTime());
                                        ProcessDetail processDetail = new ProcessDetail();
                                        processDetail.setProcessName(formInstances2.getWorkStageName());
                                        processDetail.setDays(days);
                                        processDetailList.add(processDetail);
                                    } catch (ParseException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                                if (i != size -1){
                                    try {
                                        FormInstances formInstances1 = formInstancesList.get(i);
                                        FormInstances formInstances2 = formInstancesList.get(i + 1);
                                        int days = DaysUtil.Days(formInstances1.getSupervisionTime(), formInstances2.getSupervisionTime());
                                        sb.append(formInstances1.getWorkStageName()).append("---").append(formInstances2.getWorkStageName()).append(" : ").append(days).append("天, ");
                                    } catch (ParseException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }
                            // 以及工序报验中工序的之间的时间 普通字符串
                            respData.setNameAndDays(sb.substring(0, sb.length() - 1));

                            String jsonString = JSON.toJSONString(processDetailList, SerializerFeature.WRITE_MAP_NULL_FEATURES);
                            // 以及工序报验中工序的之间的时间  用json拼接，查询的时候转换成集合
                            respData.setJsonNameAndDays(jsonString);

                            // 设置code
                            StringBuilder str = new StringBuilder();
                            List<String> strList = new ArrayList<>();
                            String parentId = respData.getParentId();
                            for (int i = 3; i > 0; i--) {
                                if (parentId != null) {
                                    FuYuZi fu = wbsDao.getFU(parentId);
                                    if (fu != null) {
                                        if (fu.getNum() != null) {
                                            strList.add(fu.getNum());
                                            parentId = fu.getParentId();
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (strList.size() > 0) {
                                Collections.reverse(strList);
                                for (String s : strList) {
                                    str.append(s).append("-");
                                }
                                respData.setNum(str.substring(0, str.length() - 1));
                            }
                        } else if (size == 1) {
                            FormInstances formInstances = formInstancesList.get(0);
                            String supervisionTime = formInstances.getSupervisionTime();
                            // 工序报验第一个监理到场时间
                            respData.setFirstSupervisionTime(supervisionTime);
                            // 工序报验最后一个监理到场时间
                            respData.setEndSupervisionTime(supervisionTime);
                            respData.setNameAndDays(formInstances.getName() + " : " + supervisionTime);
                        }
                  /*  List<String> list = wbsDao.selectWorkstageWorkReport(respData.getParentId());
                    if (list != null && list.size() > 0) {
                        respData.setReportTime(list.get(0));
                    }*/
                        respDataList.add(respData);
                }

                }
            }
        batchInsertMethodUtil.batchUpdateOrInsert(respDataList, WbsDao.class, (item, mapper) -> mapper.insertTimeForJson(item));
        System.out.println(new Date());
        System.err.println("----------------------------------------------------------------------------");

        return "添加成功";
    }

    // 计算当前wbs的每天多少米数
    private Integer getMeter(RespData respData, List<FormInstances> formInstances){
        List<Integer> startList = CalculationUtil.extractDigit(respData.getPileStart());
        List<Integer> endList = CalculationUtil.extractDigit(respData.getPileEnd());
        if (startList.size() > 0 && endList.size() > 0){
            Integer meter = CalculationUtil.compute(startList, endList);
            formInstances.sort(Comparator.comparing(FormInstances::getSupervisionTime));
            double day = 0;
            FormInstances formInstances1 = formInstances.get(0);
            FormInstances formInstances2 = formInstances.get(formInstances.size() - 1);
            try {
                day = DaysUtil.Days(formInstances1.getSupervisionTime(), formInstances2.getSupervisionTime());
                if (day == 0){
                    day = 1;
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            // 得出每天多少米数
            double augForDay = meter / day;
            return (int) Math.ceil(augForDay);
        }
        return 0;
    }

    // 根据code计算天数 和 米数  天数米数都是不为空的情况下 才会累加 然后除以不为空的数量 得出一个平均值
    public void export(){
        List<CodeAndDay> respList = new ArrayList<>();
        List<CodeAndDay> codeAndDayList = new ArrayList<>();
        List<RespData> respData = wbsDao.selectTime();
        System.err.println(respData.size());
        for (RespData respDatum : respData) {
            if (respDatum.getNum() != null){
                String[] split = respDatum.getNum().split("-");
                List<String> list = Arrays.asList(split);
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    String s1 = list.get(i).substring(0, 1);
                    s.append(s1).append("***").append(".");
                }
                codeAndDayList.add(new CodeAndDay(s.substring(0, s.length() - 1), respDatum.getDays(), respDatum.getMeter()));
            }
        }
        Map<String, List<CodeAndDay>> collect = codeAndDayList.stream().collect(Collectors.groupingBy(CodeAndDay::getCode));
        System.err.println(collect.size());
        for (String s : collect.keySet()) {
            List<CodeAndDay> codeAndDayList1 = collect.get(s);
            int day = 0;
            int meter = 0;
            int meterNum = 0;
            int dayNum = 0;
            // 将所有该子目号下面的天数累加
            for (CodeAndDay codeAndDay : codeAndDayList1) {
                if (codeAndDay.getMeter() != null){
                    meter += codeAndDay.getMeter();
                    meterNum++;
                }
                if (codeAndDay.getDay() != null){
                    day += codeAndDay.getDay();
                    dayNum++;
                }
            }
            CodeAndDay codeAndDay = new CodeAndDay();
            codeAndDay.setCode(s);
            // 然后除以累加的数量 得出一个平均数 就给该wbs赋值
            if (meter != 0){
                int num = meter / meterNum;
                codeAndDay.setMeter(num);
//                System.err.println("code码: " + s + " , 米数: " + num + "米");
            }
            if (day != 0){
                int i = day / dayNum;
                codeAndDay.setDay(i);
//                System.err.println("code码: " + s + " , 平均天数" + i );
            }
            respList.add(codeAndDay);
        }
        batchInsertMethodUtil.batchUpdateOrInsert(respList, WbsDao.class, (item, mapper) -> mapper.insertCodeAndDayAndMeter(item));

    }

    // 计算每天米数 总共的天数 对应每个的工序天数
//    @Override
    public String getMeterAndProcessAndNull() {
        List<RespData> respDataList = new ArrayList<>();

        List<RespData> wbsRespData = wbsDao.queryAllWbsRespData();
        System.err.println("wbs查询完成" + new Date() + "  , 长度为: " + wbsRespData.size());

        HashMap<String, List<FormInstances>> hashMap = new HashMap<>();
        List<FormInstances> formInstances4 = wbsDao.selectFormInstancesAll();
        System.err.println("工序查询完成" + new Date());

        // 工序找map 方便查询
        for (FormInstances formInstances : formInstances4) {
            if (hashMap.get(formInstances.getProjectNodeId()) != null){
                List<FormInstances> formInstances1 = hashMap.get(formInstances.getProjectNodeId());
                formInstances1.add(formInstances);
                hashMap.put(formInstances.getProjectNodeId(), formInstances1);
            }else {
                List<FormInstances> formInstances5 = new ArrayList<>();
                formInstances5.add(formInstances);
                hashMap.put(formInstances.getProjectNodeId(), formInstances5);
            }
        }

        for (RespData respData : wbsRespData) {
            List<FormInstances> formInstancesList = hashMap.get(respData.getWbsId());
            // 工序不为空时计算工序的数据
            if (formInstancesList != null && formInstancesList.size() > 0){
                boolean b = true;
                int num = 0;
                for (FormInstances formInstances : formInstancesList) {
                    num++;
                    // 遍历该工程单元所有的工序报验 必须都为已完成并且有两条数据以上才算 100%已完成
                    // （两条以上）去页面上看的时候，如果只有一条工序报验是已完成，它的进度是0%
                    if (formInstances.getStatus() != 3) {
                        b = false;
                    }
                }
                // 如果工序不为空 那么必须为全部工序都是完成才行
                if (b && num > 1) {
                    int size = formInstancesList.size();
                    StringBuilder sb = new StringBuilder();
                    if (size > 1) {
                        // 工序报验第一个监理到场时间
                        FormInstances instances1 = formInstancesList.get(0);
                        respData.setFirstSupervisionTime(instances1.getSupervisionTime());
                        // 工序报验最后一个监理到场时间
                        FormInstances instances2 = formInstancesList.get(size - 1);
                        respData.setEndSupervisionTime(instances2.getSupervisionTime());
                        try {
                            int days = DaysUtil.Days(instances1.getSupervisionTime(), instances2.getSupervisionTime());
                            respData.setDays(days);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }

                        // 累加的天数
                        HashMap<String, Integer> hashMap1 = new HashMap<>();
                        // 工序累加的次数
                        HashMap<String, Integer> hashMap2 = new HashMap<>();

                        List<ProcessDetail> processDetailList = new ArrayList<>();
                        for (int i = 0; i < size; i++) {
                            if (i == 0) {
                                FormInstances formInstances = formInstancesList.get(i);
                                ProcessDetail processDetail = new ProcessDetail();
                                processDetail.setProcessName(formInstances.getWorkStageName());
                                processDetail.setDays(0);
                                processDetailList.add(processDetail);
                            } else {
                                try {
                                    FormInstances formInstances1 = formInstancesList.get(i - 1);
                                    FormInstances formInstances2 = formInstancesList.get(i);
                                    int days = DaysUtil.Days(formInstances1.getSupervisionTime(), formInstances2.getSupervisionTime());
                                    if (hashMap1.get(formInstances2.getWorkStageName()) != null){
                                        hashMap1.put(formInstances2.getWorkStageName(), hashMap1.get(formInstances2.getWorkStageName() + days));
                                        hashMap2.put(formInstances2.getWorkStageName(), hashMap2.get(formInstances2.getWorkStageName()) + 1);
                                    }else {
                                        hashMap1.put(formInstances2.getWorkStageName(), days);
                                        hashMap2.put(formInstances2.getWorkStageName(), 1);
                                    }
                                } catch (ParseException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                            if (i != size -1){
                                try {
                                    FormInstances formInstances1 = formInstancesList.get(i);
                                    FormInstances formInstances2 = formInstancesList.get(i + 1);
                                    int days = DaysUtil.Days(formInstances1.getSupervisionTime(), formInstances2.getSupervisionTime());
                                    sb.append(formInstances1.getWorkStageName()).append("---").append(formInstances2.getWorkStageName()).append(" : ").append(days).append("天, ");
                                } catch (ParseException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }

                        if (hashMap1.size() > 0){
                            for (String s : hashMap1.keySet()) {
                                // 累加的天数
                                Integer integer1 = hashMap1.get(s);
                                // 累加的次数
                                Integer integer2 = hashMap2.get(s);
                                // 求出一个平均值 给这个工序赋值
                                int i = integer1 / integer2;

                                ProcessDetail processDetail = new ProcessDetail();
                                processDetail.setProcessName(s);
                                processDetail.setDays(i);
                                processDetailList.add(processDetail);
                            }
                        }

                        // 以及工序报验中工序的之间的时间 普通字符串
                        respData.setNameAndDays(sb.substring(0, sb.length() - 1));

                        String jsonString = JSON.toJSONString(processDetailList, SerializerFeature.WRITE_MAP_NULL_FEATURES);
                        // 以及工序报验中工序的之间的时间  用json拼接，查询的时候转换成集合
                        respData.setJsonNameAndDays(jsonString);
                    } else if (size == 1) {
                        FormInstances formInstances = formInstancesList.get(0);
                        String supervisionTime = formInstances.getSupervisionTime();
                        // 工序报验第一个监理到场时间
                        respData.setFirstSupervisionTime(supervisionTime);
                        // 工序报验最后一个监理到场时间
                        respData.setEndSupervisionTime(supervisionTime);
                        respData.setNameAndDays(formInstances.getName() + " : " + supervisionTime);
                    }
                    // TODO 交工报告的暂时没用 先注释
                  /*  List<String> list = wbsDao.selectWorkstageWorkReport(respData.getParentId());
                    if (list != null && list.size() > 0) {
                        respData.setReportTime(list.get(0));
                    }*/
                }
                // 桩号不为空时计算米数
            }
            if (!"".equals(respData.getPileEnd()) && respData.getPileEnd() != null  && !"".equals(respData.getPileStart()) && respData.getPileStart() != null){
                /*// 设置一天多少米数 TODO 本来是算每天多少米 现在直接根据桩号统计米数  后期再用米数和工序的所有天数再做计算
                Integer meter = getMeter(respData, formInstancesList);
                respData.setMeter(meter);*/
                List<Integer> startList = CalculationUtil.extractDigit(respData.getPileStart());
                List<Integer> endList = CalculationUtil.extractDigit(respData.getPileEnd());
                if (startList.size() > 0 && endList.size() > 0) {
                    Integer meter = CalculationUtil.compute(startList, endList);
                    respData.setMeter(meter);
                }
            }

            // 设置code
            StringBuilder str = new StringBuilder();
            List<String> strList = new ArrayList<>();
            String parentId = respData.getParentId();
            for (int i = 3; i > 0; i--) {
                if (parentId != null) {
                    FuYuZi fu = wbsDao.getFU(parentId);
                    if (fu != null) {
                        if (fu.getNum() != null) {
                            strList.add(fu.getNum());
                            parentId = fu.getParentId();
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

            if (strList.size() > 0) {
                Collections.reverse(strList);
                for (String s : strList) {
                    str.append(s).append("-");
                }
                FuYuZi fu = wbsDao.getFU(respData.getWbsId());

                respData.setNum(str + fu.getNum());
            }

            respDataList.add(respData);
        }
        batchInsertMethodUtil.batchUpdateOrInsert(respDataList, WbsDao.class, (item, mapper) -> mapper.insertTimeForJson(item));
        System.out.println(new Date());
        System.err.println("----------------------------------------------------------------------------");
        return "添加成功";
    }

    // 单独统计wbs 保存code和工序
    public String getCodeAndProcess(){
        List<ProcessJson> respDataList = new ArrayList<>();
        List<RespData> respData = wbsDao.selectTime();
        for (RespData respDatum : respData) {
            if (!"".equals(respDatum.getJsonNameAndDays()) && respDatum.getJsonNameAndDays() != null){
                if (respDatum.getNum() != null){
                    StringBuilder sb = new StringBuilder();
                    String[] split = respDatum.getNum().split("-");
                    List<String> list = Arrays.asList(split);
                    for (int i = 0; i < list.size(); i++) {
                        String s1 = list.get(i).substring(0, 1);
                        sb.append(s1).append("***").append(".");
                    }
                    ProcessJson processJson = new ProcessJson();
                    processJson.setCode(sb.substring(0, sb.length() - 1));
                    processJson.setProcessJsonStr(respDatum.getJsonNameAndDays());
                    respDataList.add(processJson);
                }
            }
        }
        batchInsertMethodUtil.batchUpdateOrInsert(respDataList, WbsDao.class, (item, mapper) -> mapper.insertProcessJsonStr(item));

        return "1";
    }

    @Override
    public void getStr() {
        List<RespData> respData = wbsDao.selectTime();
        for (RespData respDatum : respData) {
            String jsonNameAndDays = respDatum.getJsonNameAndDays();
            if (jsonNameAndDays != null){
                JSONArray jsonArray = JSONArray.parseArray(jsonNameAndDays);
                List<JsonStr> list1 = jsonArray.toJavaList(JsonStr.class);
                if (list1 != null && list1.size() > 0) {
                    int num = 0;
                    for (JsonStr jsonStr : list1) {
                        if ("钢筋加工及安装".equals(jsonStr.getProcessName())) {
                            num++;
                        }
                    }
                    if (num > 1) {
                        System.err.println(respDatum.getWbsId());

                    }
                }
            }
        }
    }
}
