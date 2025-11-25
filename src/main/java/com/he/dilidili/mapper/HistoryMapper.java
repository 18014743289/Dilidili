package com.he.dilidili.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.yulichang.base.MPJBaseMapper;
import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.model.entity.History;

public interface HistoryMapper extends MPJBaseMapper<History> {

    default History getHistoryForProductByUser(Integer product){
        return selectOne(Wrappers.<History>lambdaQuery().eq(History::getProduct, product).eq(History::getVisitor, RequestContext.getUserId()));
    }
}
