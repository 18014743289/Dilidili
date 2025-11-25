package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "任务信息DTO")
public class TaskDTO {

    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "任务名称")
    private String name;

    @Schema(description = "任务类型：0为数量型，1为质量型，2为综合型")
    private Integer type;

    @Schema(description = "任务描述")
    private String description;

    @Schema(description = "任务奖励")
    private String award;

}
