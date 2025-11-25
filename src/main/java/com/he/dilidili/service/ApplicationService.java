package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.dto.ApplicationDTO;
import com.he.dilidili.model.entity.Application;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.ApplicationVO;

public interface ApplicationService extends IService<Application> {

//    管理端获取申请条目
    PageResult<ApplicationVO> getPage(Query query);

//    管理员更新申请条目状态
    void update(ApplicationDTO applicationDTO);

//    用户发起认证申请
    void insert(ApplicationDTO applicationDTO);

}
