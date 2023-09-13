package com.security.service;

import com.security.entity.TbTableTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TbTableTime)表服务接口
 *
 * @author makejava
 * @since 2023-06-21 15:34:39
 */
public interface TbTableTimeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbTableTime queryById(Long id);

    /**
     * 分页查询
     *
     * @param tbTableTime 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbTableTime> queryByPage(TbTableTime tbTableTime, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbTableTime 实例对象
     * @return 实例对象
     */
    TbTableTime insert(TbTableTime tbTableTime);

    /**
     * 修改数据
     *
     * @param tbTableTime 实例对象
     * @return 实例对象
     */
    TbTableTime update(TbTableTime tbTableTime);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


    TbTableTime selectByProjectId(String projectId);

    int insertBatch(List<TbTableTime> TbTableTimes);

}
