package com.he.dilidili.controller;

import com.he.dilidili.common.result.Result;
import com.he.dilidili.model.vo.PersonalInformationVO;
import com.he.dilidili.service.AuthService;
import com.he.dilidili.service.CommunicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@Tag(name = "信息认证")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final CommunicationService communicationService;

    @RequestMapping(value = "/phone", method = {RequestMethod.POST})
    @Operation(summary = "验证码登录")
    public Result<PersonalInformationVO> loginByCode(@RequestParam("phone") String phone, @RequestParam("code") String code) {
        return Result.ok(authService.loginByCode(phone, code));
    }

    @RequestMapping(value = "/password", method = {RequestMethod.POST})
    @Operation(summary = "密码登录")
    public Result<PersonalInformationVO> loginByPassWord(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        return Result.ok(authService.loginByPassword(phone, password));
    }

    @RequestMapping(value = "/code", method = {RequestMethod.GET})
    @Operation(summary = "请求验证码")
    public Result<Object> sendSms(@RequestParam("phone") String phone) {
        communicationService.sendSms(phone);
        return Result.ok();
    }

    @RequestMapping(value = "/out", method = {RequestMethod.PUT})
    @Operation(summary = "登出")
    public Result<Object> logout() {
        authService.logout();
        return Result.ok();
    }
}
