package com.security.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: 况鑫威
 * @Date: 2022/6/13
 * @Time: 10:39
 * @ClassName: CreateThreadUtil
 * @Description: com.ruoyi.web.controller.util
 */
public class CreateThreadUtil {
    public static ThreadPoolExecutor createThread(int runSize){
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("分段查询数据").build();
        return new ThreadPoolExecutor(
                runSize,
                200,
                10L,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
    }

}

