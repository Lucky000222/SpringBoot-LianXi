package com.security.utils.xiao16.core.pool.simplepool;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * @author 小白
 * 创建简线程池（任务队列linkend（103）拒绝策略（重新提交任务））
 * 默认min(5)，max(10)，sleep(1000)
 */
public class PoolSimple {
    private static final TimeUnit SECONDS = TimeUnit.SECONDS;
    public static ThreadPoolExecutor poolSimple(int min, int max, long sleep ) throws InterruptedException {
        return new ThreadPoolExecutor(min, max, sleep, SECONDS, new LinkedBlockingDeque<>(103), new ThreadPoolExecutor.CallerRunsPolicy());
    }
    public static ThreadPoolExecutor poolSimple() throws InterruptedException {
        return poolSimple(5, 10, 1000);
    }
    public static ThreadPoolExecutor poolSimple(int core) throws InterruptedException {
        return poolSimple(core, core, 1000);
    }
}
