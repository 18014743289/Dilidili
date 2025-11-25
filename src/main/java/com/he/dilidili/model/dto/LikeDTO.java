package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新增点赞信息")
public class LikeDTO {

    @Schema(description = "用户ID，关联'个人信息'表")
    private Integer user;

    @Schema(description = "对象类型：0为作品，1为评论，2为弹幕评论")
    private Integer object;

    @Schema(description = "关联对象ID（作品ID、评论ID或弹幕评论ID）")
    private Integer objectId;
}
