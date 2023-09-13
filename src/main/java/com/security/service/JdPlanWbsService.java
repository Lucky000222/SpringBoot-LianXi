package com.security.service;

import com.security.entity.JdPlanWbs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * WBS计划(JdPlanWbs)表服务接口
 *
 * @author 
 * @since 2023-02-28 09:32:02
 */
public interface JdPlanWbsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JdPlanWbs queryById(String id);

    /**
     * 分页查询
     *
     * @param jdPlanWbs 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<JdPlanWbs> queryByPage(JdPlanWbs jdPlanWbs, PageRequest pageRequest);

    List<JdPlanWbs> queryList();


    /**
     * 新增数据
     *
     * @param jdPlanWbs 实例对象
     * @return 实例对象
     */
    JdPlanWbs insert(JdPlanWbs jdPlanWbs);

    /**
     * 修改数据
     *
     * @param jdPlanWbs 实例对象
     * @return 实例对象
     */
    JdPlanWbs update(JdPlanWbs jdPlanWbs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
