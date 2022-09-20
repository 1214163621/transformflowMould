package com.example.demo.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Mould;
import com.example.demo.mapper.MouldMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class MouldService {
    @Resource
    MouldMapper mouldMapper;
    public Integer create(Mould mould){
        return mouldMapper.insert(mould);
    }
    public Integer update(Mould mould){
        return mouldMapper.updateById(mould);
    }
    public Mould selectone(Mould mould){
        LambdaQueryWrapper<Mould> wrapper = Wrappers.<Mould>lambdaQuery();
        if (StrUtil.isNotBlank(mould.getMould_code())) {
            wrapper.eq(Mould::getMould_code, mould.getMould_code());
        }
        if (StrUtil.isNotBlank(mould.getName())) {
            wrapper.eq(Mould::getName, mould.getName());
        }
        return mouldMapper.selectOne(wrapper);
    }
    public Mould selectbyid(Integer id){
       return mouldMapper.selectById(id);
    }
    public Page selectPage(Integer pageNum, Integer pageSize, String mouldcode) {
        LambdaQueryWrapper<Mould> wrapper = Wrappers.<Mould>lambdaQuery();
        if (StrUtil.isNotBlank(mouldcode)) {
            wrapper.like(Mould::getMould_code ,mouldcode);
        }
        Page<Mould> page = mouldMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return page;
    }
    public List selectList() {
        LambdaQueryWrapper<Mould> wrapper = Wrappers.<Mould>lambdaQuery();
        List list = mouldMapper.selectList(wrapper);
        return list;
    }
    public Integer delete(Integer id){
        return mouldMapper.deleteById(id);
    }
}
