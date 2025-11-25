package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.mapper.HistoryMapper;
import com.he.dilidili.model.entity.History;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.HistoryVO;
import com.he.dilidili.service.HistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, History> implements HistoryService {
    @Override
    public void addHistory(Integer product,Double last) {
        History res = baseMapper.getHistoryForProductByUser(product)==null?
                new History()  : baseMapper.getHistoryForProductByUser(product);
        res.setCreateTime(LocalDateTime.now());
        res.setProduct(product);
        res.setLast(last);
        res.setVisitor(RequestContext.getUserId());
        baseMapper.insert(res);
    }

    @Override
    public PageResult<HistoryVO> getHistory(Query query) {
        return null;
    }

    @Override
    public void deleteHistory(Integer id) {
        baseMapper.deleteById(id);
    }
}
