package com.security.utils.xiao16.core.path;

import java.io.File;

/**
 * @author 小白
 *
 * 电脑系统路径（1电脑桌面||2我的文档）
 * 默认（电脑桌面）
 */

public class Path {
    public static final int SYSTEM_DESKTOP = 1;
    public static final int MY_DOCUMENT = 2;
    public static String path(int pathType) {
        javax.swing.filechooser.FileSystemView fsv = javax.swing.filechooser.FileSystemView.getFileSystemView();
        if (pathType == 1){
            File homeDirectory = fsv.getHomeDirectory();
            return homeDirectory.getAbsolutePath()+"\\";
        }
        if (pathType == 2) {
            File defaultDirectory = fsv.getDefaultDirectory();
            return defaultDirectory.getAbsolutePath()+"\\";
        }
        File homeDirectory = fsv.getHomeDirectory();
        return homeDirectory.getAbsolutePath()+"\\";
    }
    public static String path() {
        /*javax.swing.filechooser.FileSystemView fsv = javax.swing.filechooser.FileSystemView.getFileSystemView();
        File homeDirectory = fsv.getHomeDirectory();
        return homeDirectory.getAbsolutePath();*/
       return path(SYSTEM_DESKTOP);
    }
    public static  String pathClass() {
        String path = ClassLoader.class.getResource("/").getPath();
        return new File(path).getAbsolutePath()+"\\";
    }
}
