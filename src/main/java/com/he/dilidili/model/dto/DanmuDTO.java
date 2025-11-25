package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新建弹幕信息")
public class DanmuDTO {

    @Schema(description = "作品")
    private Integer product;

    @Schema(description = "弹幕内容")
    private String content;

    @Schema(description = "弹幕出现时间（单位：秒）", example = "12.5")
    private Double time;

    @Schema(description = "弹幕字体大小", example = "16px")
    private String size;

    @Schema(description = "弹幕颜色", example = " #FFFFFF")
    private String color;
}