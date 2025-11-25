package com.he.dilidili.convert;

import com.he.dilidili.model.dto.CollectDTO;
import com.he.dilidili.model.entity.Collect;
import com.he.dilidili.model.vo.CollectVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CollectConvert {
    CollectConvert INSTANCE = Mappers.getMapper(CollectConvert.class);

    Collect convert(CollectDTO dto);

    CollectVO convert(Collect collect);

    CollectVO convertTOVO(CollectDTO collectDTO);
}
