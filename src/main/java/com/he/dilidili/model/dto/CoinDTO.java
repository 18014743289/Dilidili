package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新建投币信息")
public class CoinDTO {

    @Schema(description = "作品")
    private Integer product;

    @Schema(description = "数量")
    private Integer number;
}
