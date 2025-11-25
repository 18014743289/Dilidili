package com.he.dilidili.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "PersonalInformationVO", description = "个人信息VO")
public class PersonalInformationVO {
    @Schema(description = "主键")
    private Integer id;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "官方身份认证")
    private String position;

    @Schema(description = "生日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime birthday;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "主题风格（白天0，黑夜1）")
    private Integer style;

    @Schema(description = "硬币数")
    private Long coin;

    @Schema(description = "经验值")
    private Long exp;

    @Schema(description = "积分")
    private Integer credits;

    @Schema(description = "等级")
    private Integer lv;

    @Schema(description = "角色（0：普通用户，1：管理员）")
    private Integer role;

    @Schema(description = "上次登录时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastLogin;

    @Schema(description = "癖好")
    private String hobby;

    @Schema(description = "噱头")
    private String stunt;

    @Schema(description = "令牌")
    private String accessToken;

    @Schema(description = "是否为新用户")
    private Boolean isNew;

}
