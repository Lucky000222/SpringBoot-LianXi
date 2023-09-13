package com.security.controller;

import com.security.entity.TbFloatTime;
import com.security.service.TbFloatTimeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbFloatTime)表控制层
 *
 * @author makejava
 * @since 2023-07-21 10:23:02
 */
@RestController
@RequestMapping("tbFloatTime")
public class TbFloatTimeController {
    /**
     * 服务对象
     */
    @Resource
    private TbFloatTimeService tbFloatTimeService;

    /**
     * 分页查询
     *
     * @param tbFloatTime 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbFloatTime>> queryByPage(TbFloatTime tbFloatTime, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbFloatTimeService.queryByPage(tbFloatTime, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbFloatTime> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.tbFloatTimeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbFloatTime 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbFloatTime> add(TbFloatTime tbFloatTime) {
        return ResponseEntity.ok(this.tbFloatTimeService.insert(tbFloatTime));
    }

    /**
     * 编辑数据
     *
     * @param tbFloatTime 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbFloatTime> edit(TbFloatTime tbFloatTime) {
        return ResponseEntity.ok(this.tbFloatTimeService.update(tbFloatTime));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.tbFloatTimeService.deleteById(id));
    }

}

