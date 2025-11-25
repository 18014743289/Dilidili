package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Schema(description = "新增收藏夹")
public class CollectDTO {

    @Schema(description = "收藏夹id")
    private Integer id;

    @Schema(description = "收藏夹名称")
    private String name;

    @Schema(description = "收藏夹描述")
    private String description;

    @Schema(description = "公开状态：0表示公开，1表示隐私")
    private Integer rank;

    @Schema(description = "收藏夹封面")
    private MultipartFile img;
}
