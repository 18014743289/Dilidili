package com.he.dilidili.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.model.entity.PersonalInformation;
import com.he.dilidili.model.vo.PersonalInformationVO;

public interface AuthService extends IService<PersonalInformation> {

    /**
     * 登录
     *
     * @param phone 电话
     * @param code  验证码
     * @return {@link PersonalInformationVO}
     */

    PersonalInformationVO loginByCode(String phone, String code);


     /**
     * 密码登录
     *
     * @param phone    电话
     * @param password 密码
     * @return {@link PersonalInformationVO}
     */

     PersonalInformationVO loginByPassword(String phone,String password);


    /**
     * 登出
     */
    void logout();


}
