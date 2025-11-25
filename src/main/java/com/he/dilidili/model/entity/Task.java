package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("task")
public class Task {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;        // Task name

    private String description;

    private String award;       // Award associated with the task

    private Integer end;        // Task status: 0 for not finished, 1 for finished
}
