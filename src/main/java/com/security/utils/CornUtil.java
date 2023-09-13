package com.security.utils;

import java.util.Arrays;
import java.util.List;

public class CornUtil {
    public static String StringToCron(String time, String day){
        // 固定每次触发都是0秒的时候
        String str = "0 ";
        String end = " * ?";
        // 分钟
        String minStr = "";
        // 小时
        String hourStr = "";
        // 天
        String dayStr = "*/";
        String[] split = time.split(":");
        List<String> list = Arrays.asList(split);
        minStr = list.get(1);
        hourStr = list.get(0);
        if (!"".equals(day) && day != null){
            dayStr = dayStr + day;
        }else {
            dayStr = "*";
        }
        // 最后拼接成0 30 12 */2 * ? 意思是每2天的12:30整执行一次，如果秒数不设置，则在12:30:01 -- 12:30:59 的每一秒都执行一次定时任务
        return str + minStr + " " + hourStr + " " + dayStr + end;
    }
}
