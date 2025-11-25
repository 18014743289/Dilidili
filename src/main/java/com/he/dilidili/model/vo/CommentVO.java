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

    @Schema(description = "评论者")
    private Integer utterer;

    @Schema(description = "评论者昵称")
    private String nickName;

    @Schema(description = "点赞数")
    private Integer like;

    @Schema(description = "评论者头像")
    private String avatar;

    @Schema(description = "评论内容")
    private String content;

    @Schema(description = "@谁")
    private String at;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}

