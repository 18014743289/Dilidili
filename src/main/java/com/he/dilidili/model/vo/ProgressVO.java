package com.he.dilidili.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "TaskProgressVO", description = "任务进度VO")
public class ProgressVO {
    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "任务ID")
    private Integer task;

    @Schema(description = "任务名称")
    private String name;

    @Schema(description = "任务类型：0为数量型，1为质量型，2为综合型")
    private Integer type;

    @Schema(description = "任务描述")
    private String description;

    @Schema(description = "任务奖励")
    private String award;

    @Schema(description = "任务状态：0为未完成，1为已完成")
    private Integer status;

    @Schema(description = "任务进度描述")
    private String progress;
}
