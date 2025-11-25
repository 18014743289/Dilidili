package com.he.dilidili.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name = "LikeQuery",description = "资源模糊搜索")
public class LikeQuery extends Query{

    @Schema(description = "关键词")
    private String keyword;
}
