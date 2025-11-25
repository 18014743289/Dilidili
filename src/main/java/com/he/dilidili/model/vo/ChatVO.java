package com.he.dilidili.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "ChatVO", description = "聊天信息VO")
public class ChatVO {
    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "发送者ID")
    private Integer sender;

    @Schema(description = "发送者头像")
    private String sender_avatar; // 新增字段

    @Schema(description = "发送者昵称")
    private String sender_nick_name; // 新增字段

    @Schema(description = "接收者ID")
    private Integer receiver;

    @Schema(description = "消息内容")
    private String content;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime creat_time;
}
