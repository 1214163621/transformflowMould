package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.MouldCraft;
import com.example.demo.service.MouldCraftService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/mouldcraft")
public class MouldCraftController {
    @Resource
    MouldCraftService mouldCraftService;
    @PostMapping("/create")
    public Result create(@RequestBody MouldCraft mouldCraft){
        return Result.success(mouldCraftService.create(mouldCraft));
    }
    @PostMapping("/update")
    public Result update(@RequestBody MouldCraft mouldCraft){
        return Result.success(mouldCraftService.update(mouldCraft));
    }
    @GetMapping("/getlist")
    public Result getlist(){
        return Result.success(mouldCraftService.selectList());
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer id){
        return Result.success(mouldCraftService.delete(id));
    }
}
