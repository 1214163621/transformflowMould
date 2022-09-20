package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Mould;
import com.example.demo.entity.MouldCraft;
import com.example.demo.mapper.MouldCraftMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class MouldCraftService {
    @Resource
    MouldCraftMapper mouldCraftMapper;
    public Integer create(MouldCraft mouldCraft){
        return mouldCraftMapper.insert(mouldCraft);
    }
    public Integer update(MouldCraft mouldCraft){
        return mouldCraftMapper.updateById(mouldCraft);
    }
    public Page selectPage(Integer pageNum, Integer pageSize, MouldCraft mouldCraft) {
        LambdaQueryWrapper<MouldCraft> wrapper = Wrappers.<MouldCraft>lambdaQuery();
//        if (StrUtil.isNotBlank(search)) {
//            wrapper.like(Goods::getName, search);
//        }
        Page<MouldCraft> page = mouldCraftMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return page;
    }
    public List selectList() {
        LambdaQueryWrapper<MouldCraft> wrapper = Wrappers.<MouldCraft>lambdaQuery();
        List list = mouldCraftMapper.selectList(wrapper);
        return list;
    }
    public MouldCraft selectbyid(Integer id){
        return mouldCraftMapper.selectById(id);
    }
    public Integer delete(Integer id){
        return mouldCraftMapper.deleteById(id);
    }
}
