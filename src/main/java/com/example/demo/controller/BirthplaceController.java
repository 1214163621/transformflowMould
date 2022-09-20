package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Birthplace;
import com.example.demo.service.BirthplaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/birthplace")
public class BirthplaceController {
    @Resource
    BirthplaceService birthplaceService;
    @PostMapping("/create")
    public Result create(@RequestBody Birthplace birthplace){
        return Result.success(birthplaceService.create(birthplace));
    }
    @PostMapping("/update")
    public Result update(@RequestBody Birthplace birthplace){
        return Result.success(birthplaceService.update(birthplace));
    }
    @GetMapping("/getlist")
    public Result getlist(){
        return Result.success(birthplaceService.selectList());
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer id){
        return Result.success(birthplaceService.delete(id));
    }
}