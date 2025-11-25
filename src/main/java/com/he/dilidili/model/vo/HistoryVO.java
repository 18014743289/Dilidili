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

    @Schema(description = "关联作品")
    private Integer product;

    @Schema(description = "观看时间")
    private Double last;

    @Schema(description = "作品名称")
    private String name; // 作品名称

    @Schema(description = "作品作者")
    private Integer author; // 作品作者

    @Schema(description = "作品作者昵称")
    private String nickName; // 作品作者昵称

    @Schema(description = "记录创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}
