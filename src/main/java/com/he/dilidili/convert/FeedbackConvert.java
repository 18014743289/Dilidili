package com.he.dilidili.convert;

import com.he.dilidili.model.dto.FeedbackDTO;
import com.he.dilidili.model.entity.Feedback;
import com.he.dilidili.model.vo.FeedbackVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FeedbackConvert {
    FeedbackConvert INSTANCE = Mappers.getMapper(FeedbackConvert.class);

    Feedback convert(FeedbackDTO dto);

    FeedbackVO convert(Feedback feedback);

    FeedbackVO convertTOVO(FeedbackDTO feedbackDTO);
}