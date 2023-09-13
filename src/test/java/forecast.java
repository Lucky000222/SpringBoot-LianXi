import com.security.common.GongCheng;
import com.security.common.Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class forecast {
    public static void main(String[] args) {
        Connection con = null;
        CallableStatement st;
        String fileName = "2月22java自己设置字段建模1.pcf";
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
