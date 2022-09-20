package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.entity.Mould;
import com.example.demo.service.MouldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/mould")
public class MouldController {
    @Resource
    MouldService mouldService;
    @PostMapping("/create")
    public Result create(@RequestBody Mould mould){
        return Result.success(mouldService.create(mould));
    }
    @PostMapping("/update")
    public Result update(@RequestBody Mould mould){
        return Result.success(mouldService.update(mould));
    }
    @GetMapping("/getlist")
    public Result getlist(){
        return Result.success(mouldService.selectList());
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer id){
        return Result.success(mouldService.delete(id));
    }
}
