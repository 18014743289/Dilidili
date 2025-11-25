package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("danmu")
public class Danmu {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String content;

    private Integer product;

    private LocalDateTime time;

    private LocalDateTime create_time;
}
