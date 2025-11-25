package com.he.dilidili.convert;

import com.he.dilidili.model.dto.ChatDTO;
import com.he.dilidili.model.entity.Chat;
import com.he.dilidili.model.vo.ChatVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatConvert {
    ChatConvert INSTANCE = Mappers.getMapper(ChatConvert.class);

    Chat convert(ChatDTO dto);

    ChatVO convert(Chat chat);

    ChatVO convertTOVO(ChatDTO chatDTO);
}