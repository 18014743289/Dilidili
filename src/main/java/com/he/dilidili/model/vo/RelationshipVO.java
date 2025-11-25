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

    @Schema(description = "跟随者昵称")
    private String followNickName;

    @Schema(description = "跟随者头像")
    private String followAvatar;

    @Schema(description = "粉丝昵称")
    private String fanNickName;

    @Schema(description = "粉丝头像")
    private String fanAvatar;

    @Schema(description = "关系创建时间")
    private LocalDateTime create_time;
}
