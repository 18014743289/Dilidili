package com.he.dilidili.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "NewsVO", description = "消息VO")
public class NewsVO {
    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "接收者ID")
    private Integer receiver;

    @Schema(description = "消息类型：0表示点赞，1表示@，2表示官方消息")
    private Integer type;

    @Schema(description = "消息内容")
    private String content;
}
