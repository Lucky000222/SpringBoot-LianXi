package com.security.controller;

import com.security.entity.TbSupplier;
import com.security.service.TbSupplierService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbSupplier)表控制层
 *
 * @author makejava
 * @since 2023-07-04 20:40:22
 */
@RestController
@RequestMapping("tbSupplier")
public class TbSupplierController {
    /**
     * 服务对象
     */
    @Resource
    private TbSupplierService tbSupplierService;

    /**
     * 分页查询
     *
     * @param tbSupplier 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbSupplier>> queryByPage(TbSupplier tbSupplier, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbSupplierService.queryByPage(tbSupplier, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbSupplier> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.tbSupplierService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbSupplier 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbSupplier> add(TbSupplier tbSupplier) {
        return ResponseEntity.ok(this.tbSupplierService.insert(tbSupplier));
    }

    /**
     * 编辑数据
     *
     * @param tbSupplier 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbSupplier> edit(TbSupplier tbSupplier) {
        return ResponseEntity.ok(this.tbSupplierService.update(tbSupplier));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.tbSupplierService.deleteById(id));
    }

}

