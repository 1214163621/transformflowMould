package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Mould;
import com.example.demo.entity.MouldType;
import com.example.demo.mapper.MouldTypeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class MouldTypeService {
    @Resource
    MouldTypeMapper mouldTypeMapper;
    public Integer create(MouldType mouldType){
        return mouldTypeMapper.insert(mouldType);
    }
    public Integer update(MouldType mouldType){
        return mouldTypeMapper.updateById(mouldType);
    }
    public MouldType selectbyid(Integer id){
        return mouldTypeMapper.selectById(id);
    }
    public Page selectPage(Integer pageNum, Integer pageSize, MouldType mouldType) {
        LambdaQueryWrapper<MouldType> wrapper = Wrappers.<MouldType>lambdaQuery();
//        if (StrUtil.isNotBlank(search)) {
//            wrapper.like(Goods::getName, search);
//        }
        Page<MouldType> page = mouldTypeMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return page;
    }
    public List selectList() {
        LambdaQueryWrapper<MouldType> wrapper = Wrappers.<MouldType>lambdaQuery();
        List list = mouldTypeMapper.selectList(wrapper);
        return list;
    }
    public Integer delete(Integer id){
        return mouldTypeMapper.deleteById(id);
    }


}
