package com.security.controller;

import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.security.common.Result;
import com.security.entity.FormInstances;
import com.security.service.FormInstancesService;
import com.security.utils.DateUtils;
import com.security.utils.DaysUtil;
import com.security.utils.WebV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 * (FormInstances)表控制层
 *
 * @author makejava
 * @since 2023-03-29 14:41:53
 */
@RestController
@RequestMapping("formInstances")
public class FormInstancesController {
    /**
     * 服务对象
     */
    @Resource
    private FormInstancesService formInstancesService;

    /**
     * 分页查询
     *
     * @param formInstances 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<FormInstances>> queryByPage(FormInstances formInstances, PageRequest pageRequest) {
        return ResponseEntity.ok(this.formInstancesService.queryByPage(formInstances, pageRequest));
    }

    @GetMapping("list")
    public Result list() {
        return Result.getSuccess().setData(this.formInstancesService.list());
    }

//    @GetMapping("/string")
//    public String string() {
//        // 取天气map集合
//        TreeMap<String, String> weather = getWeather();
//        String body = WebV.requestX("http://localhost:8008/formInstances/list").body();
//        JSONObject jsonObject = JSONObject.parseObject(body);
//        // 获取返回的data数据
//        JSONArray data = (JSONArray) jsonObject.get("data");
//        // 转成list
//        List<FormInstances> list = data.toJavaList(FormInstances.class);
//        list.forEach(formInstance -> {
//            if (formInstance.getStartDate() != null && formInstance.getEndDate() != null) {
//                Date startTime = DateUtils.parseDate(DaysUtil.timeFormat(formInstance.getStartDate()));
//                Date endTime = DateUtils.parseDate(DaysUtil.timeFormat(formInstance.getEndDate()));
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                String start = simpleDateFormat.format(startTime);
//                String end = simpleDateFormat.format(endTime);
//                int days = 0;
//                try {
//                    days = DaysUtil.Days(start, end);
//                } catch (ParseException e) {
//                    throw new RuntimeException(e);
//                }
//                formInstance.setDays(String.valueOf(days));
//                if (weather.get(start.substring(5, 10)) != null) {
//                    formInstance.setWeather(weather.get(start.substring(5, 10)));
//                }
//
//            }
//        });
//        String s = JSON.toJSONString(list, SerializerFeature.WRITE_MAP_NULL_FEATURES);
//        return s.substring(1, s.length() - 1);
////        return list;
//    }

    /**
     * 获取天气
     * @return
     */
    private static TreeMap<String, String> getWeather() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        FileReader fileReader = new FileReader("C:\\Users\\86189\\Desktop\\weather.txt");
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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<FormInstances> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.formInstancesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param formInstances 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<FormInstances> add(FormInstances formInstances) {
        return ResponseEntity.ok(this.formInstancesService.insert(formInstances));
    }

    /**
     * 编辑数据
     *
     * @param formInstances 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<FormInstances> edit(FormInstances formInstances) {
        return ResponseEntity.ok(this.formInstancesService.update(formInstances));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.formInstancesService.deleteById(id));
    }

    // 处理历史数据  赋值天数和天气
    @GetMapping("findAll")
    public void findAll() {
        formInstancesService.selectAll();
    }
}

   /* public void copyFile() throws IOException, ParseException {
// TODO 等会将这个写到外面  写到配置文件里
        // 文件起始位置
        // 指定数据源
        String str1 = "C:\\Users\\tolucky\\Desktop\\....txt";
        File source = new File(str1);

        // 指定目的地
        String dest = "D:\\JavaFile";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
        //创建目的地文件夹
        File destfile = new File(dest);
        if (!destfile.exists()) {
            destfile.mkdir();
        }
        BasicFileAttributes basicFileAttributes = Files.readAttributes(source.toPath(), BasicFileAttributes.class);
        //source是文件，则用字节输入输出流复制文件
        if (basicFileAttributes.isRegularFile()) {
            FileInputStream fis = new FileInputStream(source);
            //创建新的文件，保存复制内容，文件名称与源文件名称一致
//            System.out.println(dest + "\\" + sdf.format(new Date()) + source.getName());
            File dfile = new File(dest + "\\" + sdf.format(new Date()) + source.getName());
            if (!dfile.exists()) {
                dfile.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(dfile);
            // 读写数据
            // 定义数组
            byte[] b = new byte[1024];
            // 定义长度
            int len;
            // 循环读取
            while ((len = fis.read(b)) != -1) {
                // 写出数据
                fos.write(b, 0, len);
            }
            //关闭资源
            fos.close();
            fis.close();
        }
        System.out.println("复制文件成功");
    }
*/
