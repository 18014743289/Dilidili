package com.he.dilidili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("personal_information")
public class PersonalInformation {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String phone;            // Phone number (unique)

    private String nick_name;        // Nickname

    private String password;         // Password

    private String position;         // Official identity certification

    private LocalDateTime birthday;  // Birthday

    private String gender;           // Gender: 男 (Male), 女 (Female), 保密 (Secret)

    private String avatar;           // Avatar URL

    private Integer style;           // Style: 0 for day mode, 1 for night mode

    private Long coin;               // Coin count

    private Long exp;                // Experience value

    private Integer credits;         // User credits

    private Integer role;            // Role: 0 for user, 1 for admin

    private Integer rank;            // User rank

    private LocalDateTime last_login;// Last login timestamp

    private String hobby;            // Hobby

    private String stunt;            // Stunt/Signature

    private LocalDateTime create_time; // Account creation time
}
