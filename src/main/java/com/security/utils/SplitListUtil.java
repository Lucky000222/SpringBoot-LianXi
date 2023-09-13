package com.security.utils;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wxw
 * @ClassName: TimeString
 * @date 2017/8/1 18:25
 */
public final class SplitListUtil {
    /**
     * 分批的数量
     */
    public static final Integer SPLIT_NUM = 5000;


    /**
     * 分隔list
     *
     * @param list
     * @param pageSize
     * @param <T>
     * @return List
     */
    public static <T> List<List<T>> splitList(List<T> list, Integer pageSize) {
        if (pageSize == null) {
            pageSize = SPLIT_NUM;
        }
        List<List<T>> listArray = new ArrayList<List<T>>();
        List<T> subList = null;
        for (int i = 0; i < list.size(); i++) {
            //每次到达页大小的边界就重新申请一个subList
            if (i % pageSize == 0) {
                subList = new ArrayList<T>();
                listArray.add(subList);
            }
            subList.add(list.get(i));
        }
        return listArray;
    }


    /**
     * 功能描述:
     * @param: [offset 每页多少条, dataSize 需要分页的数据的长度, dataList 数据]
     * @return: java.util.List<java.util.List<T>>
     * @author: 况鑫威
     * @date: 2023/4/23
     * @time: 9:52
     */
    public static <T> List<List<T>> splitList(int offset, int dataSize, Collection<T> dataList){
        return Stream.iterate(0, i -> i+1).limit((int) Math.ceil((float)dataSize / offset)).parallel().map(n ->
                dataList.stream().skip((long) n * offset).limit(offset).parallel().collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
