package com.security.dao;

import com.security.entity.TbSupplierChangeRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TbSupplierChangeRecord)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-04 20:40:22
 */
@Mapper
public interface TbSupplierChangeRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param recordId 主键
     * @return 实例对象
     */
    TbSupplierChangeRecord queryById(Long recordId);

    /**
     * 查询指定行数据
     *
     * @param tbSupplierChangeRecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbSupplierChangeRecord> queryAllByLimit(TbSupplierChangeRecord tbSupplierChangeRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbSupplierChangeRecord 查询条件
     * @return 总行数
     */
    long count(TbSupplierChangeRecord tbSupplierChangeRecord);

    /**
     * 新增数据
     *
     * @param tbSupplierChangeRecord 实例对象
     * @return 影响行数
     */
    int insert(TbSupplierChangeRecord tbSupplierChangeRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbSupplierChangeRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbSupplierChangeRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbSupplierChangeRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbSupplierChangeRecord> entities);

    /**
     * 修改数据
     *
     * @param tbSupplierChangeRecord 实例对象
     * @return 影响行数
     */
    int update(TbSupplierChangeRecord tbSupplierChangeRecord);

    /**
     * 通过主键删除数据
     *
     * @param recordId 主键
     * @return 影响行数
     */
    int deleteById(Long recordId);

}

