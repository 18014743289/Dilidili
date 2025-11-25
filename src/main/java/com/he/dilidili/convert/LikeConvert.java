package com.he.dilidili.convert;

import com.he.dilidili.model.dto.LikeDTO;
import com.he.dilidili.model.entity.Like;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LikeConvert {
    LikeConvert INSTANCE = Mappers.getMapper(LikeConvert.class);

    Like convert(LikeDTO dto);

}