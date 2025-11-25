package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.dto.CollectionsDTO;
import com.he.dilidili.model.entity.Collections;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.CollectVO;
import com.he.dilidili.model.vo.ProductsVO;

import java.util.List;

public interface CollectionsService extends IService<Collections> {

//    打开收藏夹
    PageResult<ProductsVO> details(Query query);

//    添加收藏
    void addCollections(CollectionsDTO collectionsDTO);

//    取消收藏
    void cancelCollections(Integer id);

    List<CollectVO> isCollected(Integer id);
}
