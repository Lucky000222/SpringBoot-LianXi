package com.security.service.impl;

import com.security.entity.TbFloatTime;
import com.security.dao.TbFloatTimeDao;
import com.security.service.TbFloatTimeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbFloatTime)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 10:23:02
 */
@Service
public class TbFloatTimeServiceImpl implements TbFloatTimeService {
    @Resource
    private TbFloatTimeDao tbFloatTimeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbFloatTime queryById(Long id) {
        return this.tbFloatTimeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbFloatTime 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbFloatTime> queryByPage(TbFloatTime tbFloatTime, PageRequest pageRequest) {
        long total = this.tbFloatTimeDao.count(tbFloatTime);
        return new PageImpl<>(this.tbFloatTimeDao.queryAllByLimit(tbFloatTime, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbFloatTime 实例对象
     * @return 实例对象
     */
    @Override
    public TbFloatTime insert(TbFloatTime tbFloatTime) {
        this.tbFloatTimeDao.insert(tbFloatTime);
        return tbFloatTime;
    }

    /**
     * 修改数据
     *
     * @param tbFloatTime 实例对象
     * @return 实例对象
     */
    @Override
    public TbFloatTime update(TbFloatTime tbFloatTime) {
        this.tbFloatTimeDao.update(tbFloatTime);
        return this.queryById(tbFloatTime.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbFloatTimeDao.deleteById(id) > 0;
    }
}
