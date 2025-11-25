package com.he.dilidili.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "FeedbackVO", description = "用户反馈信息VO")
public class FeedbackVO {

    @Schema(description = "反馈ID")
    private Integer id;

    @Schema(description = "提交人ID")
    private Integer submitter;

    @Schema(description = "提交人昵称")
    private String submitter_nick_name; // 提交人昵称

    @Schema(description = "提交人头像")
    private String submitter_avatar; // 提交人头像

    @Schema(description = "反馈内容")
    private String content;

    @Schema(description = "附件")
    private String attachment;

    @Schema(description = "状态: 审核中(0), 采纳(1), 谢绝(2)")
    private Integer status;
}
