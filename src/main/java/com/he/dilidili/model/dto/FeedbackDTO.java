package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新增反馈信息")
public class FeedbackDTO {

    @Schema(description = "提交者ID")
    private Integer submitter;

    @Schema(description = "反馈内容")
    private String content;

    @Schema(description = "附件")
    private String attachment;

    @Schema(description = "状态：0为审核中，1为采纳，2为谢绝")
    private Integer status;
}
