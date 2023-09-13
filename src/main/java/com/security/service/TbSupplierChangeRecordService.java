package com.security.service;

import com.security.entity.TbSupplierChangeRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbSupplierChangeRecord)表服务接口
 *
 * @author makejava
 * @since 2023-07-04 20:40:22
 */
public interface TbSupplierChangeRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param recordId 主键
     * @return 实例对象
     */
    TbSupplierChangeRecord queryById(Long recordId);

    /**
     * 分页查询
     *
     * @param tbSupplierChangeRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbSupplierChangeRecord> queryByPage(TbSupplierChangeRecord tbSupplierChangeRecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbSupplierChangeRecord 实例对象
     * @return 实例对象
     */
    TbSupplierChangeRecord insert(TbSupplierChangeRecord tbSupplierChangeRecord);

    /**
     * 修改数据
     *
     * @param tbSupplierChangeRecord 实例对象
     * @return 实例对象
     */
    TbSupplierChangeRecord update(TbSupplierChangeRecord tbSupplierChangeRecord);

    /**
     * 通过主键删除数据
     *
     * @param recordId 主键
     * @return 是否成功
     */
    boolean deleteById(Long recordId);

}
