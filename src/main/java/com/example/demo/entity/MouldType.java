package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("mould_type")
@Data
public class MouldType {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer year;
}
