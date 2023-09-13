package com.security.utils;



import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author ruoyi
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils
{
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM",
            "dd/MM/yyyy"};

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate()
    {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate()
    {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime()
    {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow()
    {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format)
    {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date)
    {
        return parseDateToStr(YYYY_MM_DD, date);
    }
    public static final String dateTimeYYYYMM(final Date date)
    {
        return parseDateToStr(YYYY_MM, date);
    }

    public static final String parseDateToStr(final String format, final Date date)
    {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts)
    {
        try
        {
            return new SimpleDateFormat(format).parse(ts);
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str)
    {
        if (str == null)
        {
            return null;
        }
        try
        {
            return parseDate(str.toString(), parsePatterns);
        }
        catch (ParseException e)
        {
            return null;
        }
    }


    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate()
    {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算相差天数
     */
    public static int differentDaysByMillisecond(Date date1, Date date2)
    {
        return Math.abs((int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)));
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate)
    {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }
    /**
     * 计算两个时间差
     */
    public static Long getDatePoorDay(Date endDate, Date nowDate)
    {
        long nd = 1000 * 24 * 60 * 60;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        return diff / nd;
    }

    /**
     * 功能描述: 获取当前日期周几
     * @param: [pTime]
     * @return: java.lang.String
     * @author: 况鑫威
     * @date: 2021/11/22
     * @time: 13:51
     */
    public static int dayForWeek(Date date) throws Throwable {


        Calendar cal = Calendar.getInstance();

        int[] weekDays = { 7, 1, 2, 3, 4, 5, 6 };

        try {

            cal.setTime(date);

        } catch (Exception e) {

            e.printStackTrace();

        }

        // 指示一个星期中的某天。
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;

        if (w < 0) {
            w = 0;
        }

        return weekDays[w];

    }



    public static void main(String[] args) throws Throwable {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        int a = dayForWeek(new Date());
//        Calendar cal = Calendar.getInstance();
//        for (int i = 0; i < 5; i++) {
//            cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 1);
//            System.out.println(simpleDateFormat.format(cal.getTime()));
//        }
        Date date = parseDate("2023-8-20");
        System.out.println(simpleDateFormat.format(date));
        System.out.println();

    }

    /**
     * 功能描述: 增加天数后返回
     * @param: [calendar 时间组件, date 基础时间, addNumber 添加的时间]
     * @return: java.util.Date
     * @author: 况鑫威
     * @date: 2023/1/13
     * @time: 15:54
     */
    public static Date getDate(Date date, int addNumber){
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.DATE, addNumber);
        return instance.getTime();
    }
}
