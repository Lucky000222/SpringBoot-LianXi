package com.security.dao;

import com.security.entity.TbSupplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TbSupplier)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-04 20:40:22
 */
@Mapper
public interface TbSupplierDao {

    /**
     * 通过ID查询单条数据
     *
     * @param supplierId 主键
     * @return 实例对象
     */
    TbSupplier queryById(Long supplierId);

    /**
     * 查询指定行数据
     *
     * @param tbSupplier 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbSupplier> queryAllByLimit(TbSupplier tbSupplier, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbSupplier 查询条件
     * @return 总行数
     */
    long count(TbSupplier tbSupplier);

    /**
     * 新增数据
     *
     * @param tbSupplier 实例对象
     * @return 影响行数
     */
    int insert(TbSupplier tbSupplier);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbSupplier> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbSupplier> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbSupplier> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbSupplier> entities);

    /**
     * 修改数据
     *
     * @param tbSupplier 实例对象
     * @return 影响行数
     */
    int update(TbSupplier tbSupplier);

    /**
     * 通过主键删除数据
     *
     * @param supplierId 主键
     * @return 影响行数
     */
    int deleteById(Long supplierId);

}

