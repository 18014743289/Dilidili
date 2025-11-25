package com.he.dilidili.convert;

import com.he.dilidili.model.dto.TaskDTO;
import com.he.dilidili.model.entity.Task;
import com.he.dilidili.model.vo.TaskVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskConvert {
    TaskConvert INSTANCE = Mappers.getMapper(TaskConvert.class);

    Task convert(TaskDTO dto);

    TaskVO convert(Task task);

    TaskVO convertTOVO(TaskDTO taskDTO);
}