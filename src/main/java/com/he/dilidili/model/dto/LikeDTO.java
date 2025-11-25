package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新增点赞信息")
public class LikeDTO {

    @Schema(description = "对象类型：0为作品，1为评论，2为弹幕")
    private Integer object;

    @Schema(description = "关联对象（作品ID、评论ID或弹幕ID）")
    private Integer objectId;

}
