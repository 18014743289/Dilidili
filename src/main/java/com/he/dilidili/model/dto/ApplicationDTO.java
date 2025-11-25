package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "新增申请信息")
public class ApplicationDTO {

    @Schema(description = "申请人ID")
    private Integer applicant;

    @Schema(description = "证书信息")
    private String certificate;

    @Schema(description = "申请名称")
    private String name;

    @Schema(description = "申请状态：0为未审核，1为通过，2为拒绝")
    private Integer status;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}
