package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("progress")
public class Progress {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer receiver;  // Foreign key to 'personal_information' table

    private Integer task;      // Foreign key to 'task' table

    private Integer status;    // Status: 0 for not completed, 1 for completed
}
