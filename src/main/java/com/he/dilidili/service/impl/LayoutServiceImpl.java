package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.convert.LayoutConvert;
import com.he.dilidili.mapper.LayoutMapper;
import com.he.dilidili.model.dto.LayoutDTO;
import com.he.dilidili.model.entity.Layout;
import com.he.dilidili.model.vo.LayoutVO;
import com.he.dilidili.service.LayoutService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class LayoutServiceImpl extends ServiceImpl<LayoutMapper, Layout> implements LayoutService {
    @Override
    public LayoutVO getLayout(Integer id) {
        return LayoutConvert.INSTANCE.convert(baseMapper.selectOne(Wrappers.<Layout>lambdaQuery()
                .eq(Layout::getPlace,id)
                .eq(Layout::getOwner, RequestContext.getUserId())));
    }

    @Override
    public void updateLayout(LayoutDTO layoutDTO) {
        Layout res = LayoutConvert.INSTANCE.convert(layoutDTO);
        baseMapper.updateById(res);
    }

    @Override
    public void addLayout(LayoutDTO layoutDTO) {
        Layout res = LayoutConvert.INSTANCE.convert(layoutDTO);
        baseMapper.insert(res);
    }

    @Override
    public void deleteLayout(Integer id) {
        baseMapper.deleteById(id);
    }
}
