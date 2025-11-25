package com.he.dilidili.convert;

import com.he.dilidili.model.dto.PersonalInformationDTO;
import com.he.dilidili.model.entity.PersonalInformation;
import com.he.dilidili.model.vo.PersonalInformationVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonalInformationConvert {
    PersonalInformationConvert INSTANCE = Mappers.getMapper(PersonalInformationConvert.class);

    PersonalInformation convert(PersonalInformationDTO dto);

    PersonalInformationVO convert(PersonalInformation personalInformation);


    PersonalInformationVO convertTOVO(PersonalInformationDTO personalInformationDTO);
}
