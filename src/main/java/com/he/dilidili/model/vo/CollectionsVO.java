package com.he.dilidili.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "CollectionsVO", description = "收藏夹作品信息VO")
public class CollectionsVO {

    @Schema(description = "收藏夹ID")
    private Integer collection;

    @Schema(description = "作品ID")
    private Integer product;

    @Schema(description = "作品名称")
    private String product_name; // 作品昵称

    @Schema(description = "作品封面")
    private String product_cover; // 作品封面

    @Schema(description = "作品作者ID")
    private Integer product_author; // 作品作者

    @Schema(description = "作品作者昵称")
    private String product_author_nick_name; // 作品作者昵称
}
