package com.he.dilidili.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LayoutVO {
    @Schema(description = "布局ID")
    private Integer id;

    @Schema(description = "布局位置")
    private Integer place;

    @Schema(description = "布局内容")
    private String content;
}
