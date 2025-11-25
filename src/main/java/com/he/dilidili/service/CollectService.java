package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.dto.CollectDTO;
import com.he.dilidili.model.entity.Collect;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.CollectVO;

public interface CollectService extends IService<Collect> {

//    获取收藏夹
    PageResult<CollectVO> getPage(Query query);

//    更新收藏夹
    void update(CollectDTO collectDTO);

//    删除收藏夹
    void delete(Integer id);

//    添加收藏夹
    void add(CollectDTO collectDTO);

//    获取收藏夹详情
    CollectVO get(Integer id);

}
