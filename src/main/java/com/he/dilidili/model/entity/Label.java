package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("label")
public class Label {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;  // The name of the label

    private Double heat;  // The heat value of the label (default 0)
}
