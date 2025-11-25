package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("history")
public class History {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer product;  // FK to 'products' table, can be null

    private Integer visitor;  // FK to 'personal_information' table

    private Double last;

    private LocalDateTime createTime;  // Timestamp of history record creation
}
