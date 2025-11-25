package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.dto.TaskDTO;
import com.he.dilidili.model.entity.Task;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.TaskVO;

public interface TaskService extends IService<Task> {

//    查询所有任务
    PageResult<TaskVO> findAllTask(Query query);

//    发布任务
    void publishTask(TaskDTO taskDTO);
}
