package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("layout")
public class Layout {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer place;  // The place field with a comment: 'TODO 需要约定'

    private String content;  // Content for the layout

    private Integer owner;
}
