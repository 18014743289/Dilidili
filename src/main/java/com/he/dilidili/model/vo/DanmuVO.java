package com.he.dilidili.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "弹幕信息返回对象")
public class DanmuVO {

    @Schema(description = "弹幕ID")
    private Integer id;

    @Schema(description = "发送者ID")
    private Integer sender;

    @Schema(description = "弹幕内容")
    private String content;

    @Schema(description = "弹幕出现时间（单位：秒）", example = "12.5")
    private Double time;

    @Schema(description = "弹幕字体大小", example = "16px")
    private String size;

    @Schema(description = "弹幕颜色")
    private String color;

    @Schema(description = "弹幕创建时间", example = "2025-02-06 16:59:16")
    private LocalDateTime createTime;
}