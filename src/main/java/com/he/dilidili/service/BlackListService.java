package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.dto.BlackListDTO;
import com.he.dilidili.model.entity.BlackList;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.BlackListVO;

public interface BlackListService extends IService<BlackList> {

//    用户查看黑名单
    PageResult<BlackListVO> getPage(Query query);

//    取消黑名单
    void delete(Integer id);

//    添加黑名单
    void insert(BlackListDTO blackListDTO);

    
}
