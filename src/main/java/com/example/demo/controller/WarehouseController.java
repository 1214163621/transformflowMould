package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Warehouse;
import com.example.demo.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/warehouse")
public class WarehouseController {
    @Resource
    WarehouseService warehouseService;
    @PostMapping("/create")
    public Result create(@RequestBody Warehouse warehouse){
        return Result.success(warehouseService.create(warehouse));
    }
    @PostMapping("/update")
    public Result update(@RequestBody Warehouse warehouse){
        return Result.success(warehouseService.update(warehouse));
    }
    @GetMapping("/getlist")
    public Result getlist(){
        return Result.success(warehouseService.selectList());
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer id){
        return Result.success(warehouseService.delete(id));
    }
}
