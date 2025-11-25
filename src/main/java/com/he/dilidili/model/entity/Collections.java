package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("collections")
public class Collections {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer collection;

    private Integer product;
}
