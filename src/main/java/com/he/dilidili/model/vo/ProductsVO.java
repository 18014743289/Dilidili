package com.he.dilidili.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "ProductsVO", description = "作品VO")
public class ProductsVO {

    @Schema(description = "作品ID")
    private Integer id;

    @Schema(description = "作品名称")
    private String name;

    @Schema(description = "作品描述")
    private String description;

    @Schema(description = "作者ID")
    private Integer author;

    @Schema(description = "作者昵称")
    private String nickName; // 作者昵称

    @Schema(description = "作者头像")
    private String avatar; // 作者头像

    @Schema(description = "作者粉丝数")
    private Long fans; // 作者粉丝数

    @Schema(description = "作品点赞数")
    private Long likes; // 作品点赞数

    @Schema(description = "作品投币数")
    private Long coins; // 作品投币数

    @Schema(description = "作品收藏数")
    private Long collects; // 作品收藏数

    @Schema(description = "作品弹幕数")
    private Long danmus; // 作品弹幕数

    @Schema(description = "审核状态（审核中0，通过1，下线2，违规失效3）")
    private Integer status;

    @Schema(description = "点击量")
    private Long click;

    @Schema(description = "标签")
    private String label;

    @Schema(description = "作品链接")
    private String link;

    @Schema(description = "封面图URL")
    private String cover;

    @Schema(description = "是否投币")
    private Integer coin;

    @Schema(description = "是否点赞")
    private Integer like;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}
