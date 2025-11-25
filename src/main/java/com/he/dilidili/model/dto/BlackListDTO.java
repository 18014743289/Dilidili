package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新建拉黑信息")
public class BlackListDTO {

    @Schema(description = "对象类型：0为作品，1为用户")
    private Integer object;

    @Schema(description = "关联对象（作品ID或用户ID）")
    private Integer objectId;
}
