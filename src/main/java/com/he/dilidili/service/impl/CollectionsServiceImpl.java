package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.convert.CollectionsConvert;
import com.he.dilidili.mapper.CollectionsMapper;
import com.he.dilidili.model.dto.CollectionsDTO;
import com.he.dilidili.model.entity.Collections;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.CollectVO;
import com.he.dilidili.model.vo.ProductsVO;
import com.he.dilidili.service.CollectionsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CollectionsServiceImpl extends ServiceImpl<CollectionsMapper, Collections> implements CollectionsService {
    @Override
    public PageResult<ProductsVO> details(Query query) {
        return null;
    }

    @Override
    public void addCollections(CollectionsDTO collectionsDTO) {
        Collections res = CollectionsConvert.INSTANCE.convert(collectionsDTO);
        baseMapper.insert(res);
    }

    @Override
    public void cancelCollections(Integer id) {
        baseMapper.deleteById(id);
    }

    @Override
    public List<CollectVO> isCollected(Integer id) {
        return baseMapper.selectByProduct(id);
    }
}
