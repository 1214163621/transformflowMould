package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("mould")
@Data
public class Mould {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String mould_code;
    private Integer status;
}
