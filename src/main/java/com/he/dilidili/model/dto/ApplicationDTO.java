package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@Schema(description = "新增申请信息")
public class ApplicationDTO {

    @Schema(description = "凭证")
    private MultipartFile img;

    @Schema(description = "申请名称")
    private String name;

}
