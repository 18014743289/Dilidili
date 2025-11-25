package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.dto.ProgressDTO;
import com.he.dilidili.model.entity.Progress;
import com.he.dilidili.model.vo.ProgressVO;

public interface ProgressService extends IService<Progress> {

//    获取进度信息
    PageResult<ProgressVO> getProgress();

//    修改进度信息
    ProgressVO updateProgress(Integer id);

//    添加进度信息
    void addProgress(Integer id);
}
