package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Schema(description = "新增反馈信息")
public class FeedbackDTO {

    @Schema(description = "反馈内容")
    private String content;

    @Schema(description = "附件")
    private MultipartFile img;

}
