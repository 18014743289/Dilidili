package com.he.dilidili.convert;

import com.he.dilidili.model.dto.ProgressDTO;
import com.he.dilidili.model.entity.Progress;
import com.he.dilidili.model.vo.ProgressVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProgressConvert {
    ProgressConvert INSTANCE = Mappers.getMapper(ProgressConvert.class);

    Progress convert(ProgressDTO dto);

    ProgressVO convert(Progress progress);

    ProgressVO convertTOVO(ProgressDTO progressDTO);
}