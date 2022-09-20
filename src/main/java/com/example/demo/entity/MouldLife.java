package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("mould_life")
@Data
public class MouldLife {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String department;
    private String doc_code;
    private String contract_number;
    private Integer mould_id;
    private String specification;
    private Integer mould_type_id;
    private Integer mould_craft_id;
    private String money;
    private Integer brithplace_id;
    private Integer warehouse_id;
    private String create_time;
    private String input_warehouse_time;
    private Integer age;
    private String dead_time;
    private String whichBU;
    private Integer status;
}
