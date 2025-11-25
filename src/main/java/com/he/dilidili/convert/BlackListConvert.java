package com.he.dilidili.convert;

import com.he.dilidili.model.dto.BlackListDTO;
import com.he.dilidili.model.entity.BlackList;
import com.he.dilidili.model.vo.BlackListVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlackListConvert {
    BlackListConvert INSTANCE = Mappers.getMapper(BlackListConvert.class);

    BlackList convert(BlackListDTO dto);

    BlackListVO convert(BlackList blackList);

    BlackListVO convertTOVO(BlackListDTO blackListDTO);
}