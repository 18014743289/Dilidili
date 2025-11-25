package com.he.dilidili.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "CollectionsVO", description = "收藏夹作品信息VO")
public class CollectionsVO {
    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "收藏夹ID")
    private Integer collection;

    @Schema(description = "作品ID")
    private Integer product;

    @Schema(description = "作品名称")
    private String name; // 作品昵称

    @Schema(description = "作品封面")
    private String cover; // 作品封面

    @Schema(description = "作品作者ID")
    private Integer author; // 作品作者

    @Schema(description = "作品作者昵称")
    private String nickName; // 作品作者昵称
}
