package com.he.dilidili.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "关系信息VO")
public class RelationshipVO {

    @Schema(description = "关系ID")
    private Integer id;

    @Schema(description = "跟随者ID")
    private Integer follow;

    @Schema(description = "粉丝ID")
    private Integer fan;

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "关系创建时间")
    private LocalDateTime createTime;
}
