package com.security.dao;

import com.security.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * WBS工程结构表(Wbs)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-14 15:36:15
 */
@Mapper
public interface WbsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Wbs queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param wbs 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Wbs> queryAllByLimit(Wbs wbs, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param wbs 查询条件
     * @return 总行数
     */
    long count(Wbs wbs);

    /**
     * 新增数据
     *
     * @param wbs 实例对象
     * @return 影响行数
     */
    int insert(Wbs wbs);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Wbs> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Wbs> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Wbs> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Wbs> entities);

    /**
     * 修改数据
     *
     * @param wbs 实例对象
     * @return 影响行数
     */
    int update(Wbs wbs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    List<String> selectProjectIds();

    List<String> selectSectionIds(String projectId);

//    <!--  111111111111  -->
    List<FormInstances> selectFormInstances(@Param("projectNodeId")String projectNodeId);
    String selectMinTime(@Param("nodeId")String nodeId);
    String selectMaxTime(@Param("nodeId")String nodeId);
    List<String> selectWorkstageWorkReport(@Param("nodeId")String nodeId);

//    <!--  111111111111  -->



    List<RespData> selectWbsDetailTime(@Param("sectionIds")List<String> sectionIds);

    int insertTime(RespData respData);

    int insertTimeForJson(RespData respData);

    int insertCodeAndDayAndMeter(CodeAndDay codeAndDay);



    FuYuZi getFU(@Param("parentId")String parentId);

    List<Wbs> queryAllWbs();

    List<RespData> queryAllWbsRespData();


    int insertWbs1(Wbs wbs);


    List<FormInstances> selectFormInstancesAll();

    List<RespData> selectTime();

    int insertProcessJsonStr(ProcessJson processJson);
}

