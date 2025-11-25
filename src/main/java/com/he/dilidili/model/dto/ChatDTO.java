package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新建聊天记录")
public class ChatDTO {

    @Schema(description = "接收者ID")
    private Integer receiver;

    @Schema(description = "消息内容")
    private String content;

}
