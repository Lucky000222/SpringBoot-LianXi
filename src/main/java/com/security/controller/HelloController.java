package com.security.controller;

import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
//import com.ruoyi.common.utils.poi.ExcelUtil;
//import com.scudata.excel.ExcelUtils;
import com.security.Quartz.QuartzUtil;
import com.security.common.GongCheng;
import com.security.common.Result;
//import com.security.entity.Instances;
import com.security.utils.SetParamUtil;


import com.security.utils.WebV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.*;

@RestController()
@RequestMapping("/Model")
public class HelloController {

    @PostMapping("/buildModel2")
    public Result buildModelForDataBase2(String targetVariable, String fileName) {
        String respJson =" fjWbsInstanceService.queryHistoryWbs()";
//        String respJson = respJson();
        Connection con = null;
        CallableStatement st;
        boolean b = false;
        try {
            Class.forName("com.esproc.jdbc.InternalDriver");
            con = DriverManager.getConnection("jdbc:esproc:local://");
            String str =
                    "==\"" + respJson + "\"\n"+  //A1
                    "=json(A1)\n" +              //A2
                    "=ym_env()\n" +              //A3
                    "=ym_model(A3,A2)\n" +
                    "=ym_target(A4,\"" + targetVariable + "\")\n" +
                    "=ym_build_model(A4)\n";
            st = con.prepareCall(
                    str +
                            "=ym_save_pcf(A6,\"" + fileName + ".pcf\")\n" +
                            "=ym_importance(A6).sort@z(Importance)\n" +
                            "return A8");
            b = st.execute();
            JSONObject result = Result(st.getResultSet());
            System.out.println("第一个json重要度  " + result);

            String str2 =
                    "=ym_performance(A6)\n" +
                            "return A7";
            st = con.prepareCall(str + str2);
            st.execute();
            JSONObject result1 = Result(st.getResultSet());
            System.out.println("第二个json指标  " + result1);
//            Performance(str);
            if (b) {
                return Result.getSuccess().setData(b).setMsg("建模成功");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //关闭连接
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return Result.getFailure().setData(b).setMsg("建模失败");
    }

   /* public void Performance(String str1){
        Connection con = null;
        CallableStatement st;
        boolean b = false;
        try {
            String str2 =
                    "=ym_performance(A6)\n" +
                    "return A7";
            String s = str1 + str2;
            st = con.prepareCall(s);
            st.execute();
            JSONObject result1 = Result(st.getResultSet());
            System.out.println("第二个json  " + result1);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //关闭连接
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }*/

    public static JSONObject Result(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();
        JSONObject json = new JSONObject();
        // 定义两个变量名，用于保存字段名
        String name = "";
        String importance = "";
        for (int c = 1; c <= colCount; c++) {
            String title = rsmd.getColumnName(c);
            System.out.print(title);
            if (name.equals("")){
                name = title;
            }else {
                importance = title;
            }
        }
        json.set(name, importance);
        // 循环赋值返回的结果
        while (rs.next()) {
            String key = "";
            String value = "";
            for (int c = 1; c <= colCount; c++) {
                Object o = rs.getObject(c);
                if (o == null) {
                    o = "null";
                }
                if (c / 2 != 1){
                    key = o.toString();
                }else {
                    value = o.toString();
                }
            }
            json.set(key,value);
        }
        return json;
    }




        /**
         * description:建立模型   连接数据库版
         *
         * @param targetVariable 目标变量
         * @param fileName       保存的文件名
         * @return
         * @date 日期:2022/12/26 时间:11:22
         * @author 杨文斌
         */
    @PostMapping("/buildModel")
    public Result buildModelForDataBase(String targetVariable, String fileName) {
        String respJson = respJson();
        Connection con = null;
        CallableStatement st;
        boolean b = false;
        try {
//            ResultSet rs = st.executeQuery("==demo.cursor(\"select * from EMPLOYEE order by SALARY desc\")\t=[]   \n   for A1;SALARY\n  \t  >B1.insert(0,A2)  \n  return B1");
//            con = DriverManager.getConnection("jdbc:esproc:local:/?config=C:\\javaxm\\Java-lianxi\\src\\main\\resources\\raqsoftConfig.xml");
            Class.forName("com.esproc.jdbc.InternalDriver");
            con = DriverManager.getConnection("jdbc:esproc:local://");
            st = con.prepareCall(
                    "==\"" + respJson + "\"\n"+  //A1
                            "=json(A1)\n" +              //A2
                            "=ym_env()\n" +              //A3
                            "=ym_model(A3,A2)\n" +
                            "=ym_target(A4,\"" + targetVariable + "\")\n" +
                            "=ym_build_model(A4)\n" +
                            "=ym_save_pcf(A6,\"" + fileName + ".pcf\")");
            b = st.execute();
            if (b) {
                return Result.getSuccess().setData(b).setMsg("建模成功");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //关闭连接
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return Result.getFailure().setData(b).setMsg("建模失败");
    }

    /**
     * description:预测数据  连接数据库版
     *
     * @param fileName 文件名
     * @return
     * @date 日期:2022/12/29 时间:10:42
     * @author 杨文斌
     */
    @PostMapping("/forecast")
    public Result forecast(String fileName) {
        Connection con = null;
        CallableStatement st;
        try {
            Class.forName("com.esproc.jdbc.InternalDriver");
            con = DriverManager.getConnection("jdbc:esproc:local://");
            // =ym_result(A4).new() 最后只返回的值
            st = con.prepareCall(
                    "==ym_env()\n" +
                            "=ym_load_pcf(\"" + fileName + "\")\n" +
                            "=connect(\"lianxi\").query(\"select * from jd_plan_wbs_copy1\")\n" +
                            "=ym_predict(A2,A3).new(id,wbs_name,number_of_days_predictvalue)\n" +
                            "return A4"
            );
            // "=ym_result(A4).new(project_id,wbs_name,number_of_days)\n" +
            st.execute();
            ResultSet rs = st.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            List<GongCheng> list = new ArrayList<>();
            while (rs.next()) {
                GongCheng gongCheng = new GongCheng();
                for (int c = 1; c <= colCount; c++) {
                    switch (c) {
                        case 1:
                            gongCheng.setId(rs.getObject(c));
                            break;
                        case 2:
                            gongCheng.setName(rs.getObject(c));
                            break;
                        case 3:
                            gongCheng.setShichaPredictvalue(Math.round((Double) rs.getObject(c)));
                            break;
                    }
                }
                list.add(gongCheng);
            }
            System.out.println(list);
            return Result.getSuccess().setData(list).setMsg("预测成功");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //关闭连接
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return Result.getSuccess().setData(null).setMsg("预测失败");
    }

    /**
     * description:取文件里面的字段名，用来选取字段做预测数据的设置建模参数
     * 从本地文件拿数据，输入 ·+文件名.后缀
     *
     * @param
     * @return
     * @date 日期:2022/12/29 时间:10:46
     * @author 杨文斌
     */
    @GetMapping("/getModelFieldName")
    public Result modelFieldName(String fileName) {
        String respJson = respJson();
        Connection con = null;
        CallableStatement st = null;
        // 返回的字段集合
        List<String> respList = new ArrayList<>();
        try {
            Class.forName("com.esproc.jdbc.InternalDriver");
            con = DriverManager.getConnection("jdbc:esproc:local://");
            // ==connect("lianxi").query("select wbs_name,kilometre,number_of_days from jd_plan_wbs")
            st = con.prepareCall(
                    "==\"" + respJson + "\"\n"+
                        "=json(A1)\n" +
                        "return A2");

            st.execute();
            // 获取结果集
            ResultSet rs = st.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            // 获取字段个数
            int colCount = rsmd.getColumnCount();
            for (int c = 1; c <= colCount; c++) {
                // 根据下标获取字段名
                String title = rsmd.getColumnName(c);
                respList.add(title);
            }
            return Result.getSuccess().setData(respList).setMsg("查询成功");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //关闭连接
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return Result.getSuccess().setData(null).setMsg("查询失败");
    }

 /*   @Autowired
    private FjWbsInstanceService fjWbsInstanceService;*/
    /**     通过数据库
     * description:建立模型， 通过数据库建立模型，调取获取字段接口拿到字段，设置建模参数
     *
     * @param fields         设置建模参数的字符串集合
     * @param targetVariable 目标变量
     * @param fileName       保存的模型文件名
     * @return
     * @date 日期:2022/12/29 时间:16:43
     * @author 杨文斌
     */
    @PostMapping("/buildModelForDataBase")
    public Result buildModelForDataBase(String[] fields, String targetVariable,  String fileName) {
        String respJson = respJson();
        Connection con = null;
        CallableStatement st;
        boolean b = false;
        try {
            Class.forName("com.esproc.jdbc.InternalDriver");
            con = DriverManager.getConnection("jdbc:esproc:local://");
            // 字符串分为三段，最前面一段，传入需要建模的文件名
            String startStr =
                    "==\"" + respJson + "\"\n"+  //A1
                    "=json(A1)\n" +              //A2
                    "=ym_env()\n" +              //A3
                    "=ym_model(A3,A2)\n";        //A4
            // 中间一段，设置目标变量和建模参数
            // 字符串示例:  =ym_setparam(A3,"target":"shicha","modelFieldNames":["name","shicha","zui_zao_start","zui_zao_finish","zui_wan_start","zui_wan_finish","weather","dixing","superior_no"],"intelligence":"true")
            String middelStr = SetParamUtil.setParam(fields, targetVariable);  //A5
            // 最后一段，建模和设置模型文件的名字
            String endStr =
                    "=ym_build_model(A4)\n" +    //A6
                    "=ym_save_pcf(A6,\"" + fileName + ".pcf\")";   //A7
            // 字符串分为三段，拼接在一个字符串 传入进去执行SPL函数
            st = con.prepareCall(startStr + middelStr + endStr);
            b = st.execute();
            if (b) {
                return Result.getSuccess().setData(b).setMsg("建模成功");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //关闭连接
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return Result.getFailure().setData(b).setMsg("建模失败");
}

    /**
     * description: 设置字段建模，但未保存模型，只用于返回 参与建模字段的重要度排行，如要保存建模，则添加一行 save函数
     * @param
     * @return
     * @date 日期:2023/2/15 时间:15:37
     * @author 杨文斌
     */
    @PostMapping("/buildModelTwo")
    public Result buildModelForDataBaseTwo(String[] fields, String targetVariable,  String fileNam) {
        String respJson = respJson();
        Connection con = null;
        CallableStatement st;
        boolean b = false;
        try {
            //      =ym_setparam(A3,"target":"shicha","modelFieldNames":["name","shicha","zui_zao_start","zui_zao_finish","zui_wan_start","zui_wan_finish","weather","dixing","superior_no"],"intelligence":"true")
            Class.forName("com.esproc.jdbc.InternalDriver");
            con = DriverManager.getConnection("jdbc:esproc:local://");
            // 字符串分为三段，最前面一段，传入需要建模的文件名
            String startStr =                     // 目前连接数据库是写死的，固定连接某一个表
                    "==\"" + respJson + "\"\n"+  //A1
                    "=json(A1)\n" +              //A2
                    "=ym_env()\n" +
                    "=ym_model(A3,A2)\n";
            // 中间一段，设置目标变量和建模参数
            String middelStr = SetParamUtil.setParam(fields, targetVariable);
            // 最后一段，建模和设置模型文件的名字
            String endStr =
                    "=ym_build_model(A4)\n" +
                    "=ym_importance(A5).sort@z(Importance)\n" +
                    "=ym_performance(A5)\n" +
                    "return A7";
            // 字符串分为三段，拼接在一个字符串 传入进去执行SPL函数
            st = con.prepareCall(startStr + middelStr + endStr);
            b = st.execute();
            ResultSet rs = st.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            JSONObject json = new JSONObject();
            // 定义两个变量名，用于保存字段名
            String name = "";
            String importance = "";
            for (int c = 1; c <= colCount; c++) {
                String title = rsmd.getColumnName(c);
                System.out.print(title);
                if (name.equals("")){
                    name = title;
                }else {
                    importance = title;
                }
            }
            json.set(name, importance);
            // 循环赋值返回的结果
            while (rs.next()) {
                String key = "";
                String value = "";
                for (int c = 1; c <= colCount; c++) {
                    Object o = rs.getObject(c);
                    if (o == null) {
                        o = "null";
                    }
                    System.out.print(o.toString());
                    if (c / 2 != 1){
                        key = o.toString();
                    }else {
                        value = o.toString();
                    }
                }
                json.set(key,value);
            }
            if (b){
                return Result.getSuccess().setData(json).setMsg("建模成功");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //关闭连接
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return Result.getFailure().setData(b).setMsg("建模失败");
    }

    /**
     * description: 通用接口，调用接口返回json数据
     * @param
     * @return
     * @date 日期:2023/3/1 时间:14:15
     * @author 杨文斌
     */
    private static String respJson(){
        HttpResponse httpResponse = WebV.requestX("http://localhost:8008/jdPlanWbs/list");
        String replaceJson = httpResponse.body().replace("\"", "");
        return replaceJson;
    }


    /**     导入文件
     * description:建立模型，通过导入文件建立模型，调取获取字段接口拿到字段，设置建模参数
     *
     * @param fields         设置建模参数的字符串集合
     * @param targetVariable 目标变量
     * @param uploadName     上传的文件名
     * @param fileName       保存的模型文件名
     * @return
     * @date 日期:2022/12/29 时间:16:43
     * @author 杨文斌
     */
    @PostMapping("/buildModelForFile")
    public Result buildModelForFile(String[] fields, String targetVariable, String uploadName, String fileName) {
        Connection con = null;
        CallableStatement st;
        boolean b = false;
        try {
            //      =ym_setparam(A3,"target":"shicha","modelFieldNames":["name","shicha","zui_zao_start","zui_zao_finish","zui_wan_start","zui_wan_finish","weather","dixing","superior_no"],"intelligence":"true")
            Class.forName("com.esproc.jdbc.InternalDriver");
            con = DriverManager.getConnection("jdbc:esproc:local://");
            // 字符串分为三段，最前面一段，传入需要建模的文件名
            String startStr =
                    "==file(\"E:\\\\数据源\\\\" + uploadName + "\").import@qtc()\n" +
                    "=ym_env()\n" +
                    "=ym_model(A2,A1)\n";
            // 中间一段，设置目标变量和建模参数
            String middelStr = SetParamUtil.setParam(fields, targetVariable);
            // 最后一段，建模和设置模型文件的名字
            String endStr =
                    "=ym_build_model(A3)\n" +
                    "=ym_save_pcf(A5,\"" + fileName + ".pcf\")";
            // 字符串分为三段，拼接在一个字符串 传入进去执行SPL函数
            st = con.prepareCall(startStr + middelStr + endStr);
            System.out.println(startStr + middelStr + endStr);
            b = st.execute();
            if (b) {
                return Result.getSuccess().setData(b).setMsg("建模成功");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //关闭连接
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return Result.getSuccess().setData(b).setMsg("建模失败");
    }
}

//com.scudata.dm.Sequence.getMems()Lcom/scudata/dm/ListBase1;

/*if (c > 1) {
       System.out.print("\t");
     } else {
        System.out.print("\n");
   }*/