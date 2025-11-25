package com.he.dilidili.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "ApplicationVO", description = "申请信息VO")
public class ApplicationVO {
    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "申请人ID")
    private Integer applicant;

    @Schema(description = "申请人昵称")
    private String applicant_nickname;

    @Schema(description = "申请人头像")
    private String applicant_avatar;

    @Schema(description = "凭证")
    private String certificate;

    @Schema(description = "申请名称")
    private String name;

    @Schema(description = "审核状态（审核中0，通过1，下线2，违规失效3）")
    private Integer status;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime create_time;
}
