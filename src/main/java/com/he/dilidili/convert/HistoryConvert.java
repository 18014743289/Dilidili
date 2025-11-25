package com.he.dilidili.convert;

import com.he.dilidili.model.entity.History;
import com.he.dilidili.model.vo.HistoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HistoryConvert {
    HistoryConvert INSTANCE = Mappers.getMapper(HistoryConvert.class);


    HistoryVO convert(History history);

    HistoryVO convertTOVO(History dto);
}