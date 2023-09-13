package com.security.service;

import com.security.entity.TbFloatTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbFloatTime)表服务接口
 *
 * @author makejava
 * @since 2023-07-21 10:23:02
 */
public interface TbFloatTimeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbFloatTime queryById(Long id);

    /**
     * 分页查询
     *
     * @param tbFloatTime 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbFloatTime> queryByPage(TbFloatTime tbFloatTime, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbFloatTime 实例对象
     * @return 实例对象
     */
    TbFloatTime insert(TbFloatTime tbFloatTime);

    /**
     * 修改数据
     *
     * @param tbFloatTime 实例对象
     * @return 实例对象
     */
    TbFloatTime update(TbFloatTime tbFloatTime);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
