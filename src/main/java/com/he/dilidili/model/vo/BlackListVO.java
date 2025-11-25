package com.he.dilidili.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "BlackListVO", description = "黑名单信息VO")
public class BlackListVO {
    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "用户ID")
    private Integer user;

    @Schema(description = "对象类型：0为作品，1为用户")
    private Integer object;

    @Schema(description = "关联对象ID（作品ID或用户ID）")
    private Integer objectId;

    @Schema(description = "对象名称")
    private String name; // 新增字段

    @Schema(description = "对象图片")
    private String img;  // 新增字段

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}
