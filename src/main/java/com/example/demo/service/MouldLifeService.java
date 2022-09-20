package com.example.demo.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Mould;
import com.example.demo.entity.MouldLife;
import com.example.demo.mapper.MouldLifeMapper;
import com.example.demo.mapper.MouldMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class MouldLifeService {
    @Resource
    MouldLifeMapper mouldLifeMapper;
    public Integer create(MouldLife mouldLife){
        return mouldLifeMapper.insert(mouldLife);
    }
    public Integer update(MouldLife mouldLife){
        return mouldLifeMapper.updateById(mouldLife);
    }
    public Page selectPage(Integer pageNum, Integer pageSize, MouldLife mouldLife) {
        LambdaQueryWrapper<MouldLife> wrapper = Wrappers.<MouldLife>lambdaQuery();
        if (mouldLife.getMould_id() != null) {
            wrapper.eq(MouldLife::getMould_id, mouldLife.getMould_id());
        }
        if (mouldLife.getStatus() != null) {
            wrapper.eq(MouldLife::getStatus, mouldLife.getStatus());
        }
        Page<MouldLife> page = mouldLifeMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return page;
    }
    public List selectList() {
        LambdaQueryWrapper<MouldLife> wrapper = Wrappers.<MouldLife>lambdaQuery();
        List list = mouldLifeMapper.selectList(wrapper);
        return list;
    }
    public Integer delete(Integer id){
        return mouldLifeMapper.deleteById(id);
    }
}
