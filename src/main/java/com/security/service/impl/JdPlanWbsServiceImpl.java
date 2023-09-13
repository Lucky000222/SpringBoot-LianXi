package com.security.service.impl;

import com.security.entity.JdPlanWbs;
import com.security.dao.JdPlanWbsDao;
import com.security.service.JdPlanWbsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * WBS计划(JdPlanWbs)表服务实现类
 *
 * @author 
 * @since 2023-02-28 09:32:02
 */
@Service
public class JdPlanWbsServiceImpl implements JdPlanWbsService {
    @Resource
    private JdPlanWbsDao jdPlanWbsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public JdPlanWbs queryById(String id) {
        return this.jdPlanWbsDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param jdPlanWbs 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<JdPlanWbs> queryByPage(JdPlanWbs jdPlanWbs, PageRequest pageRequest) {
        long total = this.jdPlanWbsDao.count(jdPlanWbs);
        return new PageImpl<>(this.jdPlanWbsDao.queryAllByLimit(jdPlanWbs, pageRequest), pageRequest, total);
    }


    @Override
    public List<JdPlanWbs> queryList() {
        return jdPlanWbsDao.queryList();
    }

    /**
     * 新增数据
     *
     * @param jdPlanWbs 实例对象
     * @return 实例对象
     */
    @Override
    public JdPlanWbs insert(JdPlanWbs jdPlanWbs) {
        this.jdPlanWbsDao.insert(jdPlanWbs);
        return jdPlanWbs;
    }

    /**
     * 修改数据
     *
     * @param jdPlanWbs 实例对象
     * @return 实例对象
     */
    @Override
    public JdPlanWbs update(JdPlanWbs jdPlanWbs) {
        this.jdPlanWbsDao.update(jdPlanWbs);
        return this.queryById(jdPlanWbs.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.jdPlanWbsDao.deleteById(id) > 0;
    }
}
