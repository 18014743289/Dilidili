package com.he.dilidili.convert;

import com.he.dilidili.model.dto.LayoutDTO;
import com.he.dilidili.model.entity.Layout;
import com.he.dilidili.model.vo.LayoutVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LayoutConvert {
    LayoutConvert INSTANCE = Mappers.getMapper(LayoutConvert.class);

    Layout convert(LayoutDTO dto);

}