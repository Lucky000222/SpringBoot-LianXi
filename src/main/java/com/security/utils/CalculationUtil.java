package com.security.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculationUtil {

    /**
     * description:获取桩号内的数值，首先用 + 号分割，然后分别提取+号左右两端的数值做计算
     * @param  str 桩号
     * @return
     * @author 杨文斌
     */
    public static List<Integer> extractDigit(String str) {
        List<Integer> list = new ArrayList<>();
        String[] split = str.split("\\+");
        String s1 = "";
        String s2 = "";
        for (String s : split) {
            if (s.contains(".")) {
                // 有小数点的就取小数点左边的 有些脏数据是511. 2 直接丢弃
                String[] strings = s.split("\\.");
                List<String> stringList = Arrays.asList(strings);
                s = stringList.get(0).trim();
            }
            String number = getNumber(s);
            if (s1.equals("")) {
                s1 = number.trim();
            } else {
                s2 = number.trim();
            }
        }
        if (!"".equals(s1) && !"".equals(s2)){
            list.add(Integer.valueOf(s1));
            list.add(Integer.valueOf(s2));
        }else {
            return new ArrayList<>();
        }
        return list;
    }

    // 由于桩号会有A2K300这种的 正则表达式会把前面的2也保留下来  所以改用这个方法
    // 将字符串倒序遍历 从最后开始保存数字，遍历到了英文字符就结束循环
    // 去掉英文 取正确的数值
    private static String getNumber(String s){
        int length = s.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(String.valueOf(s.charAt(i)));
        }
        Collections.reverse(list);
        String number = "0123456789";
        String str = "";
        for (String s1 : list) {
            if (number.contains(s1)){
                str = s1 + str;
            }else {
                break;
            }
        }
        return str;
    }

    /**
     * description:计算两个桩号之间的距离
     * @param list1 起始桩号
     * @param list2 结束桩号
     * @return Integer 距离 (米)
     * @author ywb
     */
    public static Integer compute(List<Integer> list1, List<Integer> list2) {
        int num = 0;
        if (!Objects.equals(list1.get(0), list2.get(0))){
            int i1 = list2.get(0) - list1.get(0);
            if (i1 > 0){
                num = i1 * 1000;
            }else {
                num = -i1 * 1000;
            }
        }
        int i2 = list2.get(1) - list1.get(1);
        if (i2 > 0){
            num += i2;
        }else {
            num -= i2;
        }
        return num;
    }
}
