package com.he.dilidili.convert;

import com.he.dilidili.model.dto.CollectionsDTO;
import com.he.dilidili.model.entity.Collections;
import com.he.dilidili.model.vo.CollectionsVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CollectionsConvert {
    CollectionsConvert INSTANCE = Mappers.getMapper(CollectionsConvert.class);

    Collections convert(CollectionsDTO dto);

    CollectionsVO convert(Collections collections);

    CollectionsVO convertTOVO(CollectionsDTO collectionsDTO);
}