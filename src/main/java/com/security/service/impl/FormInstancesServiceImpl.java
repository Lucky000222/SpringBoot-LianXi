package com.security.service.impl;

import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
//import com.security.dao.FormInstances1Dao;
import com.security.entity.FormInstances;
import com.security.dao.FormInstancesDao;
import com.security.service.FormInstancesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;
import java.util.TreeMap;

/**
 * (FormInstances)表服务实现类
 *
 * @author makejava
 * @since 2023-03-29 14:41:54
 */
@Service
public class FormInstancesServiceImpl implements FormInstancesService {
    @Resource
    private FormInstancesDao formInstancesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    public FormInstances queryById(Integer id) {
        return this.formInstancesDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param formInstances 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @Override
    public Page<FormInstances> queryByPage(FormInstances formInstances, PageRequest pageRequest) {
        long total = this.formInstancesDao.count(formInstances);
        return new PageImpl<>(this.formInstancesDao.queryAllByLimit(formInstances, pageRequest), pageRequest, total);
    }

    // 获取天气
    private static TreeMap<String, String> getWeather(){
        TreeMap<String, String> treeMap = new TreeMap<>();
        FileReader fileReader = new FileReader("C:\\Users\\Luckys\\Desktop\\weather.txt");
        String s = fileReader.readString();
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONObject jsonObject1 = (JSONObject) (jsonObject.get("result"));
        JSONArray dtList = (JSONArray) jsonObject1.get("dtList");
        List<String> list = dtList.toJavaList(String.class);
        for (String s1 : list) {
            JSONObject jsonObject2 = JSONObject.parseObject(s1);
            String upTime = (String) jsonObject2.get("upTime");
            String substring = upTime.substring(5, 10);
            String wtNm = (String) jsonObject2.get("wtNm");

            if (treeMap.get(substring) != null) {
                if (treeMap.get(substring).contains("雨")) {
                    continue;
                }
            }
            treeMap.put(substring, wtNm);
        }
        return treeMap;
    }

//    @Resource
//    private FormInstances1Dao formInstances1Dao;

    @Override
    public void selectAll(){
//        TreeMap<String, String> weather = getWeather();
//        List<FormInstances> formInstances = formInstancesDao.selectAll();
//        List<FormInstances1> formInstances1s = new ArrayList<>();
//        formInstances.forEach(formInstance -> {
//            Date startTime = DateUtils.parseDate(DaysUtil.timeFormat(formInstance.getStartDate()));
//            Date endTime = DateUtils.parseDate(DaysUtil.timeFormat(formInstance.getEndDate()));
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String start = simpleDateFormat.format(startTime);
//            String end = simpleDateFormat.format(endTime);
//            int days = 0;
//            try {
//                days = DaysUtil.Days(start, end);
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//            formInstance.setDays(String.valueOf(days));
//            if (weather.get(start.substring(5, 10)) != null){
//                formInstance.setWeather(weather.get(start.substring(5, 10)));
//            }
//            FormInstances1 formInstances1 = new FormInstances1();
//            BeanUtils.copyProperties(formInstance,formInstances1);
//            formInstances1s.add(formInstances1);
//        });
//        try {
//            Thread.sleep(2000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("开始");
//        formInstances1s.forEach(formInstances1Dao::insert);
    }

    /**
     * 新增数据
     *
     * @param formInstances 实例对象
     * @return 实例对象
     */
    @Override
    public FormInstances insert(FormInstances formInstances) {
        this.formInstancesDao.insert(formInstances);
        return formInstances;
    }

    /**
     * 修改数据
     *
     * @param formInstances 实例对象
     * @return 实例对象
     */
    @Override
    public FormInstances update(FormInstances formInstances) {
        return null;
    }

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.formInstancesDao.deleteById(id) > 0;
    }

    @Override
    public List<FormInstances> list() {
        return formInstancesDao.list();

    }
}
