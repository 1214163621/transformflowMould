package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("mould_craft")
@Data
public class MouldCraft {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
}
