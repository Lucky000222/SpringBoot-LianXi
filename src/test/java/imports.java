/*
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

*/
/**
 * description
 *
 * @author 杨文斌
 * @date 日期:2023/2/23 时间:9:23
 *//*

public class imports {
   */
/* private String name;
    private Long day;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }*//*

   @Autowired
   public static JdPlanWbsDao jdPlanWbsDao;
    @Autowired
    public static JdPlanWbsService jdPlanWbsService;
    public static void main(String[] args) {

   */
/*    *//*
*/
/*List<JSONObject> list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        for (int i = 1; i <= 2000; i++) {
            jsonObject.put("id",i);
            jsonObject.put("name","wbs名字" + i);
            jsonObject.put("age",i);
            jsonObject.put("days",i);
            jsonObject.put("sex","男");
            list.add(jsonObject);
        }
        list.toString();*//*
*/
/*
        List<JdPlanWbs> jdPlanWbs = jdPlanWbsService.list();
        System.out.println(jdPlanWbs);
*//*

        Connection con = null;
        CallableStatement st = null;
        boolean b = false;
        try {
            //      =ym_setparam(A3,"target":"shicha","modelFieldNames":["name","shicha","zui_zao_start","zui_zao_finish","zui_wan_start","zui_wan_finish","weather","dixing","superior_no"],"intelligence":"true")
            Class.forName("com.esproc.jdbc.InternalDriver");
            con = DriverManager.getConnection("jdbc:esproc:local://");
            // 字符串分为三段，拼接在一个字符串 传入进去执行SPL函数

//            st.setObject(1,list)
           */
/* st = con.prepareCall(
                    list.toString()+"\n"+
                            "=ym_env() ");
            b = st.execute();*//*


            ResultSet rs = st.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            for (int c = 1; c <= colCount; c++) {
                String title = rsmd.getColumnName(c);
                if (c > 1) {
                    System.out.print("\t");
                } else {
                    System.out.print("\n");
                }
                System.out.print(title);
            }
            while (rs.next()) {
                for (int c = 1; c <= colCount; c++) {
                    if (c > 1) {
                        System.out.print("\t");

                    } else {
                        System.out.print("\n");
                    }
//                    double shicha_predictvalue = rs.getDouble("shicha_predictvalue");
//                    System.out.println(shicha_predictvalue);
                    Object o = rs.getObject(c);
                    System.out.print(o.toString());
                }
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
    }
}
*/
