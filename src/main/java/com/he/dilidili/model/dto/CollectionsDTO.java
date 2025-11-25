package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新增收藏关联信息")
public class CollectionsDTO {

    @Schema(description = "收藏ID")
    private Integer collection;

    @Schema(description = "产品ID")
    private Integer product;
}
