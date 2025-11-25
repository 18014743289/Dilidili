package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "新增评论信息")
public class CommentDTO {

    @Schema(description = "评论者ID")
    private Integer utterer;

    @Schema(description = "评论内容")
    private String content;

    @Schema(description = "评论的产品ID")
    private Integer product;

    @Schema(description = "附加ID")
    private Integer attach;

    @Schema(description = "评论的目标对象")
    private String aim;

    @Schema(description = "评论创建时间")
    private LocalDateTime createTime;
}
