package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新增金币信息")
public class CoinDTO {

    @Schema(description = "产品ID")
    private Integer product;

    @Schema(description = "付款人ID")
    private Integer payer;

    @Schema(description = "金币数量")
    private Integer number;
}
