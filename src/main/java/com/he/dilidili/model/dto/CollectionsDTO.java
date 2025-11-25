package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新增收藏")
public class CollectionsDTO {

    @Schema(description = "收藏夹")
    private Integer collection;

    @Schema(description = "作品")
    private Integer product;
}
