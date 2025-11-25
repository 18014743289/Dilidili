package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.convert.PersonalInformationConvert;
import com.he.dilidili.mapper.PersonalInformationMapper;
import com.he.dilidili.model.dto.PersonalInformationDTO;
import com.he.dilidili.model.entity.PersonalInformation;
import com.he.dilidili.model.query.KeyQuery;
import com.he.dilidili.model.vo.PersonalInformationVO;
import com.he.dilidili.service.PersonalInformationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@AllArgsConstructor
public class PersonalInformationServiceImpl extends ServiceImpl<PersonalInformationMapper, PersonalInformation> implements PersonalInformationService {
    @Override
    public PersonalInformationVO getPersonalInformation(Integer id) {
        return PersonalInformationConvert.INSTANCE.convert(baseMapper.selectById(id));
    }

    @Override
    public PersonalInformationVO updatePersonalInformation(PersonalInformationDTO personalInformationDTO) {
        PersonalInformation res = PersonalInformationConvert.INSTANCE.convert(personalInformationDTO);
        res.setId(RequestContext.getUserId());
        baseMapper.updateById(res);
        res = baseMapper.selectById(res.getId());
        return PersonalInformationConvert.INSTANCE.convert(res);
    }

    @Override
    public void updateAvatar(MultipartFile file) {

    }

    @Override
    public void addPersonalInformation(String phone) {

    }

    @Override
    public void deletePersonalInformation(Integer id) {

    }

    @Override
    public PageResult<PersonalInformationVO> searchPersonalInformation(KeyQuery keyQuery) {
        return null;
    }

    @Override
    public String getNickName(Integer id) {
        return baseMapper.selectById(id).getNickName();
    }
}
