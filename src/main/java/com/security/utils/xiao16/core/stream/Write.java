package com.security.utils.xiao16.core.stream;
import cn.hutool.core.io.file.FileWriter;
/**
 * @author 小白
 * 写出文件（字节）utf-8
 *
 */
public class Write {

    // 覆盖
    public static boolean writeFile(String path, byte[] write){
        FileWriter writer = new FileWriter(path);
        return writer.write(write,0,write.length).canExecute();
    }
    /*public static boolean writeFile(String path, byte[] write,String charset) throws UnsupportedEncodingException {
        FileWriter writer = new FileWriter(path,charset);
        return writer.write(ToType.toText(write)).canExecute();

    }*/
    // 追加
    public static boolean writeAdd(String path, byte[] write){
        FileWriter writer = new FileWriter(path);
       return writer.append(write,0,write.length).canExecute();
    }
    /*public static boolean writeAdd(String path, byte[] write,String charset) throws UnsupportedEncodingException {
        FileWriter writer = new FileWriter(path,charset);
       return writer.append(ToType.toText(write)).canExecute();
    }*/
}

