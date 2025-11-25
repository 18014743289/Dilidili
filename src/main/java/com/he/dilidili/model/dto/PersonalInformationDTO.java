package com.he.dilidili.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "更新个人信息")
public class PersonalInformationDTO {

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "生日")
    private LocalDateTime birthday;

    @Schema(description = "性别：男（Male），女（Female），保密（Secret）")
    private String gender;

    @Schema(description = "风格：0为日间模式，1为夜间模式")
    private Integer style;

    @Schema(description = "经验值")
    private Long exp;

    @Schema(description = "用户积分")
    private Integer credits;

    @Schema(description = "用户等级")
    private Integer lv;

    @Schema(description = "最后登录时间")
    private LocalDateTime lastLogin;

    @Schema(description = "爱好")
    private String hobby;

    @Schema(description = "噱头")
    private String stunt;

}
