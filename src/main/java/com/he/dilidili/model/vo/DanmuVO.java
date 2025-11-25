package com.he.dilidili.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "DanmuVO", description = "弹幕VO")
public class DanmuVO {

    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "弹幕内容")
    private String content;

    @Schema(description = "关联的产品ID")
    private Integer product;

    @Schema(description = "弹幕时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
