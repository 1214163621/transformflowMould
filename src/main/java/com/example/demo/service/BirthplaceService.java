package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Birthplace;
import com.example.demo.entity.Mould;
import com.example.demo.mapper.BirthplaceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class BirthplaceService {
    @Resource
    BirthplaceMapper birthplaceMapper;
    public Integer create(Birthplace birthplace){
        return birthplaceMapper.insert(birthplace);
    }
    public Integer update(Birthplace birthplace){
        return birthplaceMapper.updateById(birthplace);
    }
    public Page selectPage(Integer pageNum, Integer pageSize, Birthplace birthplace) {
        LambdaQueryWrapper<Birthplace> wrapper = Wrappers.<Birthplace>lambdaQuery();
//        if (StrUtil.isNotBlank(search)) {
//            wrapper.like(Goods::getName, search);
//        }
        Page<Birthplace> page = birthplaceMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return page;
    }
    public Birthplace selectbyid(Integer id){
        return birthplaceMapper.selectById(id);
    }
    public List selectList() {
        LambdaQueryWrapper<Birthplace> wrapper = Wrappers.<Birthplace>lambdaQuery();
        List list = birthplaceMapper.selectList(wrapper);
        return list;
    }
    public Integer delete(Integer id){
        return birthplaceMapper.deleteById(id);
    }
}
