package com.he.dilidili.convert;

import com.he.dilidili.model.dto.ApplicationDTO;
import com.he.dilidili.model.entity.Application;
import com.he.dilidili.model.vo.ApplicationVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicationConvert {
    ApplicationConvert INSTANCE = Mappers.getMapper(ApplicationConvert.class);

    Application convert(ApplicationDTO dto);

    ApplicationVO convert(Application application);

    ApplicationVO convertTOVO(ApplicationDTO applicationDTO);
}