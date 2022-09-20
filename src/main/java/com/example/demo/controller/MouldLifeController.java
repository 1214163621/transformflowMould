package com.example.demo.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Mould;
import com.example.demo.entity.MouldLife;
import com.example.demo.entity.MouldType;
import com.example.demo.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@Slf4j
@RequestMapping("/mouldlife")
public class MouldLifeController {
    @Resource
    MouldService mouldService;
    @Resource
    MouldLifeService mouldLifeService;
    @Resource
    MouldTypeService mouldTypeService;
    @Resource
    MouldCraftService mouldCraftService;
    @Resource
    BirthplaceService birthplaceService;
    @Resource
    WarehouseService warehouseService;
    @PostMapping("/create")
//    事务
    @Transactional
    public Result create(@RequestBody JSONObject jsonObject){
        List mouldlist = jsonObject.getJSONArray("detail");
        Iterator<JSONObject> iterator = mouldlist.iterator();
        while (iterator.hasNext()){
            JSONObject detialjson = (JSONObject) JSONObject.toJSON(iterator.next());
            System.out.println(detialjson.toJSONString());
            MouldLife mouldLife = new MouldLife();
            Mould mould = new Mould();
            mould.setMould_code(detialjson.getString("mould_id"));
            mould.setName(detialjson.getString("mould_name"));
            mould.setStatus(1);
            if(mouldService.create(mould)==1){
                mouldLife.setMould_id(mouldService.selectone(mould).getId());
                mouldLife.setDepartment(detialjson.getString("department"));
                mouldLife.setDoc_code(detialjson.getString("doc_code"));
                mouldLife.setContract_number(detialjson.getString("contract_number"));
                mouldLife.setSpecification(detialjson.getString("specification"));
                mouldLife.setMould_type_id(Integer.valueOf(detialjson.getString("mould_type_id")));
                mouldLife.setMould_craft_id(Integer.valueOf(detialjson.getString("mould_craft_id")));
                mouldLife.setMoney(detialjson.getString("money"));
                mouldLife.setBrithplace_id(Integer.valueOf(detialjson.getString("birthplace_id")));
                mouldLife.setWarehouse_id(Integer.valueOf(detialjson.getString("warehouse_id")));
                mouldLife.setCreate_time(jsonObject.getString("create_time"));
                mouldLife.setInput_warehouse_time(detialjson.getString("input_warehouse_time"));
                Integer year =  mouldTypeService.selectbyid(Integer.valueOf(detialjson.getString("mould_type_id"))).getYear();
                mouldLife.setAge(year);
                Date date = DateUtil.parse(detialjson.getString("input_warehouse_time"));
                Date newdate = DateUtil.offset(date, DateField.YEAR,year);
                Date deaddate = DateUtil.offsetDay(newdate,-1);
                mouldLife.setDead_time(String.valueOf(deaddate));
                mouldLife.setWhichBU(detialjson.getString("whichBU"));
                mouldLife.setStatus(1);
                mouldLifeService.create(mouldLife);
            }
        }
        return Result.success();
    }
    @PostMapping("/update")
    @Transactional
    public Result update(@RequestBody JSONObject jsonObject){
        MouldLife mouldLife = new MouldLife();
        mouldLifeService.update(mouldLife);
        return Result.success();
    }
    @PostMapping("/getlist")
    @Transactional
    public Result getlist(@RequestBody JSONObject jsonObject){
        String mouldcode = jsonObject.getString("mouldcode");

        Page page = mouldService.selectPage(1,10,mouldcode);
        Iterator<Mould> iterator = page.getRecords().iterator();
        List list = new ArrayList();
        while(iterator.hasNext()){
            MouldLife mouldLife = new MouldLife();
            Integer mouldid = iterator.next().getId();
            mouldLife.setMould_id(mouldid);
            mouldLife.setStatus(1);
            List mouldlifelist = mouldLifeService.selectPage(1, 1, mouldLife).getRecords();
            if (mouldlifelist.size() != 0){
                list.add(mouldlifelist.get(0));
            }
        }
//        MouldLife mouldLife = new MouldLife();
        List newlist = new ArrayList();
        Iterator<MouldLife> iterator1 =  list.iterator();
        while (iterator1.hasNext()){
             MouldLife mouldLife = iterator1.next();
            Map<String, Object> map = BeanUtil.beanToMap(mouldLife);
            map.put("mouldname",mouldService.selectbyid(mouldLife.getMould_id()).getName());
            map.put("mouldcode",mouldService.selectbyid(mouldLife.getMould_id()).getMould_code());
            map.put("birthplace",birthplaceService.selectbyid(mouldLife.getBrithplace_id()).getName());
            map.put("craft",mouldCraftService.selectbyid(mouldLife.getMould_craft_id()).getName());
            map.put("mouldtype",mouldTypeService.selectbyid(mouldLife.getMould_type_id()).getName());
            map.put("warehouse",warehouseService.selectbyid(mouldLife.getWarehouse_id()).getName());
            newlist.add(map);
        }
        return Result.success(newlist);
//        return Result.success();
    }
}
