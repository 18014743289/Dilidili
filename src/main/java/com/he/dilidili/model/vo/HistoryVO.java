package com.he.dilidili.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "HistoryVO", description = "历史记录VO")
public class HistoryVO {
    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "关联产品ID")
    private Integer product;

    @Schema(description = "访问者ID")
    private Integer visitor;

    @Schema(description = "记录创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}
