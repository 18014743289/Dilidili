package com.he.dilidili.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "TaskVO", description = "任务VO")
public class TaskVO {

    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "任务名称")
    private String name;

    @Schema(description = "任务描述")
    private String description;

    @Schema(description = "任务奖励")
    private String award;

    @Schema(description = "任务状态：0为未完成，1为已完成")
    private Integer status;
}
