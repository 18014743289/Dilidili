package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("black_list")
public class BlackList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer user;

    /**
     * 作品 0，用户 1
     */
    private Integer object;

    private Integer objectId;

}
