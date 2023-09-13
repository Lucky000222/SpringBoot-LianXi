package com.security.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.Future;
import java.util.function.BiFunction;

/**
 * @author: 况鑫威
 * @Date: 2023/4/7
 * @Time: 15:30
 * @ClassName: BatchInsertMethodUtil
 * @Description: com.kingroad.progress.util
 */
@Component
@Slf4j
public class BatchInsertMethodUtil {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    public static Integer countNum = 1;
    /**
     * 批量处理修改或者插入(如果数据量太大，请切割后放入，以防内存溢出)
     *
     * @param data        需要被处理的数据
     * @param mapperClass Mybatis的Mapper类
     * @param function    自定义处理逻辑
     * @return int 影响的总行数
     */
    public <T,U,R> Future<Integer>  batchUpdateOrInsert(List<T> data,  Class<U> mapperClass, BiFunction<T,U,R> function) {
        long l = System.currentTimeMillis();
        System.out.println("插入开始时间===============================================" + l);
        SqlSession batchSqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            int i = 1;
            U mapper = batchSqlSession.getMapper(mapperClass);
            int size = data.size();
            for (T element : data) {
                function.apply(element,mapper);
                if ((i % SplitListUtil.SPLIT_NUM == 0) || i == size) {
                    //防止内存溢出
                    batchSqlSession.flushStatements();
                    System.out.println("5000条插入完成时间===============================================" + (System.currentTimeMillis() - l));
                }
                i++;
                countNum++;
            }
            batchSqlSession.commit();
        } catch (Exception e) {
            batchSqlSession.rollback();
            log.error("第" + (countNum + 1) + "条插入失败：" + e.getMessage());
            throw new ConcurrentModificationException("第" + (countNum + 1) + "条插入失败：" + e.getMessage());
        }finally {
            batchSqlSession.close();
            System.out.println("插入完成时间===============================================" + (System.currentTimeMillis() - l));
        }
        countNum = 0;
        return AsyncResult.forValue(countNum - 1);
    }

}
