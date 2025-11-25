package com.he.dilidili.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.model.entity.Collect;
import com.he.dilidili.model.entity.Collections;
import com.he.dilidili.model.vo.CollectVO;

import java.util.List;

public interface CollectionsMapper extends MPJBaseMapper<Collections> {
    default List<CollectVO> selectByProduct(Integer id) {
        MPJLambdaWrapper<Collections> wrapper = new MPJLambdaWrapper<>(Collections.class);
        wrapper.eq(Collections::getProduct, id)
                .leftJoin(Collect.class, Collect::getId, Collections::getCollection)
                .eq(Collect::getOwner, RequestContext.getUserId());
        return this.selectJoinList(CollectVO.class,wrapper);
    }
}
