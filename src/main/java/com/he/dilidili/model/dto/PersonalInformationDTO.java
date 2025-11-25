package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "新增个人信息")
public class PersonalInformationDTO {

    @Schema(description = "手机号（唯一）")
    private String phone;

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "官方身份认证")
    private String position;

    @Schema(description = "生日")
    private LocalDateTime birthday;

    @Schema(description = "性别：男（Male），女（Female），保密（Secret）")
    private String gender;

    @Schema(description = "头像URL")
    private String avatar;

    @Schema(description = "风格：0为日间模式，1为夜间模式")
    private Integer style;

    @Schema(description = "金币数")
    private Long coin;

    @Schema(description = "经验值")
    private Long exp;

    @Schema(description = "用户积分")
    private Integer credits;

    @Schema(description = "角色：0为普通用户，1为管理员")
    private Integer role;

    @Schema(description = "用户等级")
    private Integer rank;

    @Schema(description = "最后登录时间")
    private LocalDateTime lastLogin;

    @Schema(description = "爱好")
    private String hobby;

    @Schema(description = "签名/绝技")
    private String stunt;

    @Schema(description = "账户创建时间")
    private LocalDateTime createTime;
}
