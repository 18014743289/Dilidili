package com.he.dilidili.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.yulichang.base.MPJBaseMapper;
import com.he.dilidili.model.entity.PersonalInformation;

public interface PersonalInformationMapper extends MPJBaseMapper<PersonalInformation> {

    default PersonalInformation getByPhone(String phone){
        return selectOne(Wrappers.<PersonalInformation>lambdaQuery().eq(PersonalInformation::getPhone,phone));
    }
}
