package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.entity.History;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.HistoryVO;

public interface HistoryService extends IService<History> {

//    添加历史记录
    void addHistory(Integer product,Double last);

//    获取历史记录
    PageResult<HistoryVO> getHistory(Query query);

//    删除历史记录
    void deleteHistory(Integer id);

}
