package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.mapper.TaskMapper;
import com.he.dilidili.model.dto.TaskDTO;
import com.he.dilidili.model.entity.Task;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.TaskVO;
import com.he.dilidili.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {
    @Override
    public PageResult<TaskVO> findAllTask(Query query) {
        return null;
    }

    @Override
    public void publishTask(TaskDTO taskDTO) {

    }
}
