package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("coin")
public class Coin {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer product;

    private Integer payer;

    private Integer number;
}
