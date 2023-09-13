package com.security.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * description
 *
 * @author 杨文斌
 * @date 日期:2023/2/15 时间:9:02
 */
public class DaysUtil {
    /**
     * description: 两个时间内的天数差 yyyy-MM-dd
     * @param beginTime 开始时间 endTime 结束时间
     * @return int 中间的天数差
     * @author 杨文斌
     */
    public static int Days(String beginTime, String endTime) throws ParseException {
        List<String> allDate = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = sdf.parse(beginTime);
        Date end = sdf.parse(endTime);
        allDate.add(sdf.format(begin));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(begin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(end);
        // 测试此日期是否在指定日期之后
        while (end.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            allDate.add(sdf.format(calBegin.getTime()));
        }
//        System.out.println("时间: " + allDate);
        return allDate.size();
    }

    /**
     * 返回的某一段时间内的日期，存进集合
     * @param beginTime
     * @param endTime
     * @return
     * @throws ParseException
     */
    public static List<String> DaysToList(String beginTime, String endTime) throws ParseException {
        List<String> allDate = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = sdf.parse(beginTime);
        Date end = sdf.parse(endTime);
        allDate.add(sdf.format(begin));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(begin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(end);
        // 测试此日期是否在指定日期之后
        while (end.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            allDate.add(sdf.format(calBegin.getTime()));
        }
//        System.out.println("时间: " + allDate);
        return allDate;
    }

        /**  时间格式转换
         *  将23/7/2021 这种格式的时间 分割 再反转 再拼接 2021-7-23
         * @param stringTime
         * @return
         */
    public static String timeFormat(String stringTime){
        String time ="";
        String[] split = stringTime.split("/");
        List<String> strings = Arrays.asList(split);
        // 将23/7/2021 这种格式的时间 分割 再反转 再拼接 2021-7-23
        Collections.reverse(strings);
        time = strings.get(0) + "-" + strings.get(1) + "-" + strings.get(2);
        return time;
    }
}
