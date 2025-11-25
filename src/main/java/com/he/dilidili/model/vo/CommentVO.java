package com.he.dilidili.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "CommentVO", description = "评论VO")
public class CommentVO {

    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "评论者ID")
    private Integer utterer;

    @Schema(description = "评论内容")
    private String content;

    @Schema(description = "关联的产品ID")
    private Integer product;

    @Schema(description = "附件ID")
    private Integer attach;

    @Schema(description = "评论目标")
    private String aim;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
