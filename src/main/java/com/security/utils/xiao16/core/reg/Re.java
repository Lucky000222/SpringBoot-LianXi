package com.security.utils.xiao16.core.reg;

import cn.hutool.core.util.ReUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 小白
 * 正则表达式
 * 超级方便好用
 * reg（正则匹配）
 * rep(正则替换)
 */
public class Re {
    private static final Pattern GROUP_VAR = Pattern.compile("\\$(\\d+)",32);
    public static List<String> reg(String regex,String content){
        ArrayList<String> all = ReUtil.findAll(regex, content, 1, new ArrayList<String>());
        if (all.size() == 0) {

           all.add(null);
        }
        return all;
    }
    public static List<String> reg(String regex,String content,String template){
        ArrayList<String> list = new ArrayList<String>();
        Matcher matcher = Pattern.compile(regex, Pattern.DOTALL).matcher(content);
        if (template==null){
            while (matcher.find()) {
                list.add(matcher.group(1));
            }
        }else {
            Matcher m =GROUP_VAR.matcher(template);
            int i = 0;
            while (m.find()) {
                i++;
            }
            while (matcher.find()){
                String temp =template;
                for (int i1 = 0; i1 < i; i1++) {
                    m.find(i1);
                    temp=temp.replace(m.group(0),matcher.group(i1+1));
                }
                list.add(temp);
            }
        }
        if (list.size() == 0) {
            list.add(null);
        }
        return list;
    }


    public static List<String> reg(String regex,String content,int group){
        ArrayList<String> all = ReUtil.findAll(regex, content, group, new ArrayList<String>());
        if (all.size() == 0) {

            all.add(null);
        }
        return all;
    }
    public static String rep(String regex,String content,String replace){
        return ReUtil.replaceAll(content, regex, replace);
    }

}