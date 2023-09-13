package com.security.service.impl;

import com.security.entity.TbTableTime;
import com.security.dao.TbTableTimeDao;
import com.security.service.TbTableTimeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbTableTime)表服务实现类
 *
 * @author makejava
 * @since 2023-06-21 15:34:39
 */
@Service
public class TbTableTimeServiceImpl implements TbTableTimeService {
    @Resource
    private TbTableTimeDao tbTableTimeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbTableTime queryById(Long id) {
        return this.tbTableTimeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbTableTime 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbTableTime> queryByPage(TbTableTime tbTableTime, PageRequest pageRequest) {
        long total = this.tbTableTimeDao.count(tbTableTime);
        return new PageImpl<>(this.tbTableTimeDao.queryAllByLimit(tbTableTime, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbTableTime 实例对象
     * @return 实例对象
     */
    @Override
    public TbTableTime insert(TbTableTime tbTableTime) {
        this.tbTableTimeDao.insert(tbTableTime);
        return tbTableTime;
    }

    /**
     * 修改数据
     *
     * @param tbTableTime 实例对象
     * @return 实例对象
     */
    @Override
    public TbTableTime update(TbTableTime tbTableTime) {
        this.tbTableTimeDao.update(tbTableTime);
        return this.queryById(tbTableTime.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbTableTimeDao.deleteById(id) > 0;
    }

    @Override
    public TbTableTime selectByProjectId(String projectId) {
        return tbTableTimeDao.selectByProjectId(projectId);
    }

    @Override
    public int insertBatch(List<TbTableTime> TbTableTimes) {
        return tbTableTimeDao.insertBatch(TbTableTimes);


    }
}
