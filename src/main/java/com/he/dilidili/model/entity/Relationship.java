package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("relationship")
public class Relationship {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer follow;        // Foreign key to 'personal_information' table (the user being followed)

    private Integer fan;           // Foreign key to 'personal_information' table (the follower)

    private LocalDateTime createTime; // Creation timestamp of the relationship
}
