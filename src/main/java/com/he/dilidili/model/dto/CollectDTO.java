package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新增收藏信息")
public class CollectionDTO {

    @Schema(description = "所有者ID")
    private Integer owner;

    @Schema(description = "收藏名称")
    private String name;

    @Schema(description = "收藏描述")
    private String description;

    @Schema(description = "公开状态：0表示公开，1表示隐私")
    private Integer rank;
}
