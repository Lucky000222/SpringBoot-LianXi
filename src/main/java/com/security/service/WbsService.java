package com.security.service;

import com.security.entity.Wbs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * WBS工程结构表(Wbs)表服务接口
 *
 * @author makejava
 * @since 2023-07-14 15:36:15
 */
public interface WbsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Wbs queryById(String id);

    /**
     * 分页查询
     *
     * @param wbs 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Wbs> queryByPage(Wbs wbs, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param wbs 实例对象
     * @return 实例对象
     */
    Wbs insert(Wbs wbs);

    /**
     * 修改数据
     *
     * @param wbs 实例对象
     * @return 实例对象
     */
    Wbs update(Wbs wbs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    String getTime();

    String getTime1();

    String getKilometres();

    String getMeterAndProcess();

    void export();

    // 统计全部数据 包括工序为空的wbs  但是有工序的 工序就必须全部完成才会去统计工序的数据
    String getMeterAndProcessAndNull();

    String getCodeAndProcess();

    void getStr();
}
