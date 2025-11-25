package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "新增产品信息")
public class ProductsDTO {

    @Schema(description = "产品名称")
    private String name;

    @Schema(description = "产品描述")
    private String description;

    @Schema(description = "作者ID，关联'个人信息'表")
    private Integer author;

    @Schema(description = "产品状态：0为审核中，1为已通过，2为已下架，3为无效")
    private Integer status;

    @Schema(description = "点击数")
    private Long click;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "产品标签")
    private String label;

    @Schema(description = "产品链接")
    private String link;

    @Schema(description = "产品封面图URL")
    private String cover;
}
