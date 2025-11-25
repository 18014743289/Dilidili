package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("application")
public class Application {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer applicant;

    private String certificate;

    private String name;

    private Integer status;

    private LocalDateTime createTime;
}
