package com.security.service.impl;

import com.security.entity.TbSupplier;
import com.security.dao.TbSupplierDao;
import com.security.service.TbSupplierService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbSupplier)表服务实现类
 *
 * @author makejava
 * @since 2023-07-04 20:40:22
 */
@Service("tbSupplierService")
public class TbSupplierServiceImpl implements TbSupplierService {
    @Resource
    private TbSupplierDao tbSupplierDao;

    /**
     * 通过ID查询单条数据
     *
     * @param supplierId 主键
     * @return 实例对象
     */
    @Override
    public TbSupplier queryById(Long supplierId) {
        return this.tbSupplierDao.queryById(supplierId);
    }

    /**
     * 分页查询
     *
     * @param tbSupplier 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbSupplier> queryByPage(TbSupplier tbSupplier, PageRequest pageRequest) {
        long total = this.tbSupplierDao.count(tbSupplier);
        return new PageImpl<>(this.tbSupplierDao.queryAllByLimit(tbSupplier, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbSupplier 实例对象
     * @return 实例对象
     */
    @Override
    public TbSupplier insert(TbSupplier tbSupplier) {
        this.tbSupplierDao.insert(tbSupplier);
        return tbSupplier;
    }

    /**
     * 修改数据
     *
     * @param tbSupplier 实例对象
     * @return 实例对象
     */
    @Override
    public TbSupplier update(TbSupplier tbSupplier) {
        this.tbSupplierDao.update(tbSupplier);
        return this.queryById(tbSupplier.getSupplierId());
    }

    /**
     * 通过主键删除数据
     *
     * @param supplierId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long supplierId) {
        return this.tbSupplierDao.deleteById(supplierId) > 0;
    }
}
