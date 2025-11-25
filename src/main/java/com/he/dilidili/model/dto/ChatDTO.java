package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "新增聊天信息")
public class ChatDTO {

    @Schema(description = "发送者ID")
    private Integer sender;

    @Schema(description = "接收者ID")
    private Integer receiver;

    @Schema(description = "消息内容")
    private String content;

    @Schema(description = "创建时间")
    private LocalDateTime creat_time; // 保持与原始字段一致的大小写和格式
}
