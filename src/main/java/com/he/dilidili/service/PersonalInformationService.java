package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.dto.PersonalInformationDTO;
import com.he.dilidili.model.entity.PersonalInformation;
import com.he.dilidili.model.query.KeyQuery;
import com.he.dilidili.model.vo.PersonalInformationVO;
import org.springframework.web.multipart.MultipartFile;

public interface PersonalInformationService extends IService<PersonalInformation> {

//    获取个人信息
    PersonalInformationVO getPersonalInformation(Integer id);

//    修改个人信息
    PersonalInformationVO updatePersonalInformation(PersonalInformationDTO personalInformationDTO);

//    更换头像
    void updateAvatar(MultipartFile file);

//    添加个人信息
    void addPersonalInformation(String phone);

//    删除个人信息
    void deletePersonalInformation(Integer id);

//    模糊搜索
    PageResult<PersonalInformationVO> searchPersonalInformation(KeyQuery keyQuery);

    String getNickName(Integer id);
}
