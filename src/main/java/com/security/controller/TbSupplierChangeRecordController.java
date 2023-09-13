package com.security.controller;

import com.security.entity.TbSupplierChangeRecord;
import com.security.service.TbSupplierChangeRecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbSupplierChangeRecord)表控制层
 *
 * @author makejava
 * @since 2023-07-04 20:40:22
 */
@RestController
@RequestMapping("tbSupplierChangeRecord")
public class TbSupplierChangeRecordController {
    /**
     * 服务对象
     */
    @Resource
    private TbSupplierChangeRecordService tbSupplierChangeRecordService;

    /**
     * 分页查询
     *
     * @param tbSupplierChangeRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbSupplierChangeRecord>> queryByPage(TbSupplierChangeRecord tbSupplierChangeRecord, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbSupplierChangeRecordService.queryByPage(tbSupplierChangeRecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbSupplierChangeRecord> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.tbSupplierChangeRecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbSupplierChangeRecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbSupplierChangeRecord> add(TbSupplierChangeRecord tbSupplierChangeRecord) {
        return ResponseEntity.ok(this.tbSupplierChangeRecordService.insert(tbSupplierChangeRecord));
    }

    /**
     * 编辑数据
     *
     * @param tbSupplierChangeRecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbSupplierChangeRecord> edit(TbSupplierChangeRecord tbSupplierChangeRecord) {
        return ResponseEntity.ok(this.tbSupplierChangeRecordService.update(tbSupplierChangeRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.tbSupplierChangeRecordService.deleteById(id));
    }

}

