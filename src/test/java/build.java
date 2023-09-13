import cn.hutool.json.JSONObject;
import com.security.common.Result;
import com.security.utils.SetParamUtil;

import java.sql.*;

// 建模
public class build {
    public static void main(String[] args) {

        // 目标变量
        String targetVariable = "number_of_days";
        // 参与建模的字段
        String[] fields = {"wbs_name","kilometre","number_of_days"};
        String fileName = "2月22java自己设置字段建模1";

        Connection con = null;
        CallableStatement st;
        boolean b = false;
        try {
            //      =ym_setparam(A3,"target":"shicha","modelFieldNames":["name","shicha","zui_zao_start","zui_zao_finish","zui_wan_start","zui_wan_finish","weather","dixing","superior_no"],"intelligence":"true")
            Class.forName("com.esproc.jdbc.InternalDriver");
            con = DriverManager.getConnection("jdbc:esproc:local://");
            // 字符串分为三段，最前面一段，传入需要建模的文件名
            String startStr =                     // 目前连接数据库是写死的，固定连接某一个表
                    "==connect(\"lianxi\").query(\"select * from jd_plan_wbs\")\n" +
                    "=ym_env()\n" +
                    "=ym_model(A2,A1)\n";
            // 中间一段，设置目标变量和建模参数
            String middelStr = SetParamUtil.setParam(fields, targetVariable);
            // 最后一段，建模和设置模型文件的名字
            String endStr =
                    "=ym_build_model(A3)\n" +
                    "=ym_save_pcf(A5,\"" + fileName + ".pcf\")\n" +
                    "=ym_importance(A5).sort@z(Importance)\n" +
//                    "=ym_performance(A5)\n" +
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
//                System.out.print(title);
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
//                    System.out.print(o.toString());
                    if (c / 2 != 1){
                        key = o.toString();
                    }else {
                        value = o.toString();
                    }
                }
                json.set(key,value);
            }
//            if (b){
//                return Result.getSuccess().setData(json).setMsg("建模成功");
//            }
            System.out.println(json);
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
//        return Result.getFailure().setData(b).setMsg("建模失败");
    }

}
