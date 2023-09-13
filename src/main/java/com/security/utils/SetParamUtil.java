package com.security.utils;

/**
 * description
 *
 * @author 杨文斌
 * @date 日期:2022/12/30 时间:13:51
 */
public class SetParamUtil {

    /**
     * description:方法描述
     * @param  遍历数组，取字段名再拼接成建模所需的字符串
     */
    public static String setParam(String[] fields, String targetVariable){
        String s1 = "=ym_setparam(A4,\"target\":\"";
        s1 += targetVariable;
        String s2 = "\",\"field\":[";
        StringBuilder s3 = new StringBuilder();
        s1 += s2;
        boolean b = false;
        for (String field : fields) {
            if (!b){
                s3.append("\"").append(field).append("\"".trim());
                b = true;
            }else {
                s3.append(",\"").append(field).append("\"".trim());
            }
        }
        s1 += s3;
        String s4 = "],\"intelligence\":\"false\")\n";
        s1 += s4;
        return s1;
    }
}
