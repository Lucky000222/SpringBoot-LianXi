package com.security.service.impl;

import com.security.entity.TbSupplierChangeRecord;
import com.security.dao.TbSupplierChangeRecordDao;
import com.security.service.TbSupplierChangeRecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbSupplierChangeRecord)表服务实现类
 *
 * @author makejava
 * @since 2023-07-04 20:40:22
 */
@Service("tbSupplierChangeRecordService")
public class TbSupplierChangeRecordServiceImpl implements TbSupplierChangeRecordService {
    @Resource
    private TbSupplierChangeRecordDao tbSupplierChangeRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param recordId 主键
     * @return 实例对象
     */
    @Override
    public TbSupplierChangeRecord queryById(Long recordId) {
        return this.tbSupplierChangeRecordDao.queryById(recordId);
    }

    /**
     * 分页查询
     *
     * @param tbSupplierChangeRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbSupplierChangeRecord> queryByPage(TbSupplierChangeRecord tbSupplierChangeRecord, PageRequest pageRequest) {
        long total = this.tbSupplierChangeRecordDao.count(tbSupplierChangeRecord);
        return new PageImpl<>(this.tbSupplierChangeRecordDao.queryAllByLimit(tbSupplierChangeRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbSupplierChangeRecord 实例对象
     * @return 实例对象
     */
    @Override
    public TbSupplierChangeRecord insert(TbSupplierChangeRecord tbSupplierChangeRecord) {
        this.tbSupplierChangeRecordDao.insert(tbSupplierChangeRecord);
        return tbSupplierChangeRecord;
    }

    /**
     * 修改数据
     *
     * @param tbSupplierChangeRecord 实例对象
     * @return 实例对象
     */
    @Override
    public TbSupplierChangeRecord update(TbSupplierChangeRecord tbSupplierChangeRecord) {
        this.tbSupplierChangeRecordDao.update(tbSupplierChangeRecord);
        return this.queryById(tbSupplierChangeRecord.getRecordId());
    }

    /**
     * 通过主键删除数据
     *
     * @param recordId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long recordId) {
        return this.tbSupplierChangeRecordDao.deleteById(recordId) > 0;
    }
}
