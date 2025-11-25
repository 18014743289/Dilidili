package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("collect")
public class Collect {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer owner;

    private String name;

    private String description;

    private Integer rank; // 公开 0, 隐私 1

    private String cover;
}
