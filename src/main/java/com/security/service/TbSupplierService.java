package com.security.service;

import com.security.entity.TbSupplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbSupplier)表服务接口
 *
 * @author makejava
 * @since 2023-07-04 20:40:22
 */
public interface TbSupplierService {

    /**
     * 通过ID查询单条数据
     *
     * @param supplierId 主键
     * @return 实例对象
     */
    TbSupplier queryById(Long supplierId);

    /**
     * 分页查询
     *
     * @param tbSupplier 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbSupplier> queryByPage(TbSupplier tbSupplier, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbSupplier 实例对象
     * @return 实例对象
     */
    TbSupplier insert(TbSupplier tbSupplier);

    /**
     * 修改数据
     *
     * @param tbSupplier 实例对象
     * @return 实例对象
     */
    TbSupplier update(TbSupplier tbSupplier);

    /**
     * 通过主键删除数据
     *
     * @param supplierId 主键
     * @return 是否成功
     */
    boolean deleteById(Long supplierId);

}
