package com.he.dilidili.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "CollectVO", description = "收藏夹VO")
public class CollectVO {
    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "收藏夹名称")
    private String name;

    @Schema(description = "收藏夹描述")
    private String description;

    @Schema(description = "公开状态：0表示公开，1表示隐私")
    private Integer rank;

    @Schema(description = "收藏夹封面")
    private String cover;

    // 添加新的字段
    @Schema(description = "收藏夹创建时间")
    private LocalDateTime createTime;

    @Schema(description = "收藏夹更新时间")
    private LocalDateTime updateTime;
}
