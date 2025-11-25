package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("products")
public class Products {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;            // Product name

    private String description;     // Product description

    private Integer author;         // Foreign key to 'personal_information' table

    private Integer status;         // Status: 0 for in review, 1 for approved, 2 for offline, 3 for invalid

    private Long click;             // Click count

    private LocalDateTime createTime; // Creation time

    private String label;           // Product label

    private String link;            // Product link

    private String cover;           // Product cover image URL
}
