package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.MouldType;
import com.example.demo.service.MouldTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/mouldtype")
public class MouldTypeController {
    @Resource
    MouldTypeService mouldTypeService;
    @PostMapping("/create")
    public Result create(@RequestBody MouldType mouldType){
        return Result.success(mouldTypeService.create(mouldType));
    }
    @PostMapping("/update")
    public Result update(@RequestBody MouldType mouldType){
        return Result.success(mouldTypeService.update(mouldType));
    }
    @GetMapping("/getlist")
    public Result getlist(){
        return Result.success(mouldTypeService.selectList());
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer id){
        return Result.success(mouldTypeService.delete(id));
    }
}
