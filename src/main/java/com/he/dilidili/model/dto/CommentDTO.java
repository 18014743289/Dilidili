package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新增评论信息")
public class CommentDTO {

    @Schema(description = "评论内容")
    private String content;

    @Schema(description = "评论的作品")
    private Integer product;

    @Schema(description = "附属的对象")
    private Integer attach;

    @Schema(description = "@谁")
    private String at;

}
