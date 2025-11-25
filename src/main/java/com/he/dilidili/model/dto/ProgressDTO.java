package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "进度信息DTO")
public class ProgressDTO {

    @Schema(description = "接收者ID")
    private Integer receiver;

    @Schema(description = "任务ID")
    private Integer task;

    @Schema(description = "状态：0为未完成，1为已完成")
    private Integer status;

    @Schema(description = "进度描述")
    private String description;
}
