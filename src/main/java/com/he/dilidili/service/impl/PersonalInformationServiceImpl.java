package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.mapper.PersonalInformationMapper;
import com.he.dilidili.model.entity.PersonalInformation;
import com.he.dilidili.service.PersonalInformationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PersonalInformationServiceImpl extends ServiceImpl<PersonalInformationMapper, PersonalInformation> implements PersonalInformationService {
}
