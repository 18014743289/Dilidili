package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("feedback")
public class Feedback {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer submitter;

    private String content;

    private String attachment;

    private Integer status; // 状态: 审核中(0), 采纳(1), 谢绝(2)
}
