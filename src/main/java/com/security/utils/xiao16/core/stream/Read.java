package com.security.utils.xiao16.core.stream;

import cn.hutool.core.io.file.FileReader;

/**
 * @author 小白
 *
 * 读入文件（字节）
 *
 * charset(utf-8||gbk||...)
 */
public class Read {
    public static byte[] readFile(String path){
        FileReader read = new FileReader(path);
        return read.readBytes();
    }
    public static byte[] readFile(String path,String charset){
        FileReader read = new FileReader(path,charset);
        return read.readBytes();
    }

}
