package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新增布局信息")
public class LayoutDTO {

    @Schema(description = "位置字段（待约定）")
    private Integer place;

    @Schema(description = "布局内容")
    private String content;
}
