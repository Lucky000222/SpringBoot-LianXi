package com.security.controller;

import com.security.entity.TbTableTime;
import com.security.service.TbTableTimeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbTableTime)表控制层
 *
 * @author makejava
 * @since 2023-06-21 15:34:29
 */
@RestController
@RequestMapping("tbTableTime")
public class TbTableTimeController {
    /**
     * 服务对象
     */
    @Resource
    private TbTableTimeService tbTableTimeService;

    /**
     * 分页查询
     *
     * @param tbTableTime 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbTableTime>> queryByPage(TbTableTime tbTableTime, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbTableTimeService.queryByPage(tbTableTime, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbTableTime> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.tbTableTimeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbTableTime 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbTableTime> add(TbTableTime tbTableTime) {
        return ResponseEntity.ok(this.tbTableTimeService.insert(tbTableTime));
    }

    /**
     * 编辑数据
     *
     * @param tbTableTime 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbTableTime> edit(TbTableTime tbTableTime) {
        return ResponseEntity.ok(this.tbTableTimeService.update(tbTableTime));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.tbTableTimeService.deleteById(id));
    }

}

