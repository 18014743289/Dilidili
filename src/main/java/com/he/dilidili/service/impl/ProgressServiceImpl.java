package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.mapper.ProgressMapper;
import com.he.dilidili.model.entity.Progress;
import com.he.dilidili.model.vo.ProductsVO;
import com.he.dilidili.model.vo.ProgressVO;
import com.he.dilidili.service.ProductsService;
import com.he.dilidili.service.ProgressService;
import com.he.dilidili.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ProgressServiceImpl extends ServiceImpl<ProgressMapper, Progress> implements ProgressService {
    private final TaskService taskService;
    private final ProductsService productsService;
    @Override
    public PageResult<ProgressVO> getProgress() {
        return null;
    }

    @Override
    public ProgressVO updateProgress(Integer id) {
//        TODO 获取任务，遍历作品，更新进度
        String description = taskService.getById(id).getDescription();
        int now = 0;
        switch (description.split(",")[1]){
            case"like":
                for (ProductsVO product:productsService.getProductsByAuthorId(RequestContext.getUserId())){
//                    TODO
                }
            case"click":
            case"coin":

        }
        int count = 0;
        return null;
    }

    @Override
    public void addProgress(Integer id) {
        int stand = Integer.parseInt(taskService.getById(id).getDescription().split(",")[2]);
        Progress progress = new Progress();
        progress.setReceiver(RequestContext.getUserId());
        progress.setTask(id);
        progress.setProgress("0,"+stand);
        baseMapper.insert(progress);
    }
}
