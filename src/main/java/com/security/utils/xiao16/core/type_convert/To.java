package com.security.utils.xiao16.core.type_convert;

import java.io.UnsupportedEncodingException;
/**
 * @author 小白
 *
 * 类型转换
 */
public class To {

    //到字符串
    public static String toText(Object ob) {
        return String.valueOf(ob);
    }
    public static String toText(byte[] bytes) {
        return new String(bytes);
    }
    public static String toText(byte[] bytes, String charSet) throws UnsupportedEncodingException {
        return new String(bytes, charSet);
    }
    //到整数
    public static int toInt(String str) {
        return Integer.parseInt(str);
    }
    public static int toInt(byte[] bytes) {
        return Integer.parseInt(String.valueOf(bytes));
    }
    //到字节
    public static byte[] toBytes(String str) {
        return str.getBytes();
    }
    public static byte[] toBytes(String str,String charSet) throws UnsupportedEncodingException {
        return str.getBytes(charSet);
    }
    public static byte[] toBytes(Object ints) {
        return toBytes(toText(ints));
    }
}
