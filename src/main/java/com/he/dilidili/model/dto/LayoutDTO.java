package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "布局信息")
public class LayoutDTO {

    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "位置字段")
    private Integer place;

    @Schema(description = "布局内容")
    private String content;

    @Schema(description = "所有人")
    private Integer owner;
}
