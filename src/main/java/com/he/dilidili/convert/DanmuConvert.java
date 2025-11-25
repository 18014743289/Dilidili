package com.he.dilidili.convert;

import com.he.dilidili.model.dto.DanmuDTO;
import com.he.dilidili.model.entity.Danmu;
import com.he.dilidili.model.vo.DanmuVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DanmuConvert {
    DanmuConvert INSTANCE = Mappers.getMapper(DanmuConvert.class);

    Danmu convert(DanmuDTO dto);

    DanmuVO convert(Danmu danmu);

    DanmuVO convertTOVO(DanmuDTO danmuDTO);
}