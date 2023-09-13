package com.security.service;

import com.security.entity.FormInstances;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.text.ParseException;
import java.util.List;

/**
 * (FormInstances)表服务接口
 *
 * @author makejava
 * @since 2023-03-29 14:41:53
 */
public interface FormInstancesService {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    FormInstances queryById(Integer id);

    /**
     * 分页查询
     *
     * @param formInstances 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<FormInstances> queryByPage(FormInstances formInstances, PageRequest pageRequest);

    void selectAll();

    /**
     * 新增数据
     * @param formInstances 实例对象
     * @return 实例对象
     */
    FormInstances insert(FormInstances formInstances);

    /**
     * 修改数据
     *
     * @param formInstances 实例对象
     * @return 实例对象
     */
    FormInstances update(FormInstances formInstances);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<FormInstances> list();
}
