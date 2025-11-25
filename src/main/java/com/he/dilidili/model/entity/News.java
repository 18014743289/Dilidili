package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("news")
public class News {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer receiver;  // Foreign key to 'personal_information' table

    private Integer type;      // Type of news: 0 for like, 1 for @, 2 for official

    private String content;    // Content of the news
}
