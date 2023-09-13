package com.security.utils;



import cn.hutool.core.util.ReUtil;

import java.util.*;

/**
 * @author 小白
 * <p>
 * 文本处理
 * 文本创建
 * 超级好用
 */
public class txt {
    /**
     * RMtext
     * Max(大范围)
     * min(小范围)
     * List(批量提取)
     * 取出中间文本
     *
     * @param str   源文本
     * @param aims1 目标文本1
     * @param aims2 目标文本2
     * @return
     */
    //RMtext
    public static String rmtext_Max(String str, String aims1, String aims2) {
        int index1 = str.indexOf(aims1);
        if (index1 == -1) {
            return null;
        }
        int index2 = str.lastIndexOf(aims2);
        if (index2 == -1) {
            return null;
        }
        return str.substring(index1 + aims1.length(), index2);
    }

    public static String rmtext_Min(String str, String aims1, String aims2) {
        int index1 = str.indexOf(aims1);
        if (index1 == -1) {
            return null;
        }
        int index2 = str.indexOf(aims2, index1);
        if (index2 == -1) {
            return null;
        }
        return str.substring(index1 + aims1.length(), index2);
    }

    public static List<String> rmtext_List(String str, String aims1, String aims2) {
        List<String> reg = reg(aims1 + "(.*?)" + aims2, str);
        if (reg.get(0) == null) {
            return null;
        }
        return reg;
    }

    //取出文本左边
    //RLtext
    public static String rltext(String str, String aims1) {
        int index1 = str.indexOf(aims1);
        if (index1 == -1) {
            return null;
        }
        return str.substring(0, index1);
    }

    //取出文本右边
    //RRtext
    public static String rrtext(String str, String aims1) {
        int index1 = str.indexOf(aims1);
        if (index1 == -1) {
            return null;
        }
        return str.substring(index1 + aims1.length());
    }

    //创建文本   "lwef{1}js{2}f" --> 2,"ewewr" --> ="lwef2jsewewrf"
    public static String createString(String str, Object... arg) {
        if (str != null && !Objects.equals(str, "")) {
            for (int i = 1; i <= arg.length + 1; i++) {
                if (str.contains("{" + i + "}")) {
                    str = str.replaceAll("\\{" + i + "}", toText(arg[i - 1]));
                } else {
                    break;
                }
            }
            return str;
        }
        return null;
    }
    //到字符串
    public static String toText(Object ob) {
        return String.valueOf(ob);
    }

    //创建文本替换
    public static String createReplace(String str, Object... arg) {
        if (str != null && !Objects.equals(str, "")) {
            int i1 = (arg.length + 1) / 2;
            for (int i = 1; i <= i1; i++) {
                str = str.replaceAll((String) (arg[i * 2 - 2]), toText(arg[i * 2 - 1]));
            }
            return str;
        }
        return null;
    }


    //去重复lists<String||Integer>
    public static List<String> rdstring(List<String> list) {
        return new ArrayList<String>(new TreeSet<String>(list));
    }

    public static List<Integer> rdintegers(List<Integer> list) {
        return new ArrayList<Integer>(new TreeSet<Integer>(list));
    }

    public static List<String> rdstring(String[] array) {
        return new ArrayList<String>(new TreeSet<String>(Arrays.asList(array)));
    }

    public static List<Integer> rdintegers(Integer[] array) {
        return new ArrayList<Integer>(new TreeSet<Integer>(Arrays.asList(array)));
    }

    public static List<String> reg(String regex,String content){
        ArrayList<String> all = ReUtil.findAll(regex, content, 1, new ArrayList<String>());
        if (all.size() == 0) {

            all.add(null);
        }
        return all;
    }

}
