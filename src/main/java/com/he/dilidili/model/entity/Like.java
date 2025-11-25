package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("like")
public class Like {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer user;      // Foreign key to 'personal_information' table

    private Integer object;    // The type of object: 0 for works, 1 for comments, 2 for bullet comments

    private Integer objectId;  // The ID of the associated object (work, comment, or bullet comment)
}
