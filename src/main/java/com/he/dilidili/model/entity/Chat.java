package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("chat")
public class Chat {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer sender;

    private Integer receiver;

    private String content;

    private LocalDateTime creatTime; // 使用 String 类型保存日期时间格式，必要时可改为 LocalDateTime
}
