package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Schema(description = "更新作品信息")
public class ProductsDTO {

    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "作品名称")
    private String name;

    @Schema(description = "作品描述")
    private String description;

    @Schema(description = "作者")
    private Integer author;

    @Schema(description = "状态：0为审核中，1为已通过，2为已下架，3为无效")
    private Integer status;

    @Schema(description = "点击数")
    private Long click;

    @Schema(description = "标签")
    private String label;

    @Schema(description = "作品")
    private MultipartFile product;

    @Schema(description = "封面图")
    private MultipartFile img;
}
