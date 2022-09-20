package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Mould;
import com.example.demo.entity.Warehouse;
import com.example.demo.mapper.MouldMapper;
import com.example.demo.mapper.WarehouseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class WarehouseService {
    @Resource
    WarehouseMapper warehouseMapper;
    public Integer create(Warehouse warehouse){
        return warehouseMapper.insert(warehouse);
    }
    public Integer update(Warehouse warehouse){
        return warehouseMapper.updateById(warehouse);
    }
    public Page selectPage(Integer pageNum, Integer pageSize, Warehouse warehouse) {
        LambdaQueryWrapper<Warehouse> wrapper = Wrappers.<Warehouse>lambdaQuery();
//        if (StrUtil.isNotBlank(search)) {
//            wrapper.like(Goods::getName, search);
//        }
        Page<Warehouse> page = warehouseMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return page;
    }
    public List selectList() {
        LambdaQueryWrapper<Warehouse> wrapper = Wrappers.<Warehouse>lambdaQuery();
        List list = warehouseMapper.selectList(wrapper);
        return list;
    }
    public Warehouse selectbyid(Integer id){
        return warehouseMapper.selectById(id);
    }
    public Integer delete(Integer id){
        return warehouseMapper.deleteById(id);
    }
}
