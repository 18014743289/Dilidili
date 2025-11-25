package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.convert.CollectConvert;
import com.he.dilidili.mapper.CollectMapper;
import com.he.dilidili.model.dto.CollectDTO;
import com.he.dilidili.model.entity.Collect;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.CollectVO;
import com.he.dilidili.service.CollectService;
import com.he.dilidili.utils.UpLoadUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {
    UpLoadUtils upLoadUtils;
    @Override
    public PageResult<CollectVO> getPage(Query query) {
        return null;
    }

    @Override
    public void update(CollectDTO collectDTO) {
        Collect res = CollectConvert.INSTANCE.convert(collectDTO);
        baseMapper.updateById(res);
    }

    @Override
    public void delete(Integer id) {
        baseMapper.deleteById(id);
    }

    @Override
    public void add(CollectDTO collectDTO) {
        Collect res = CollectConvert.INSTANCE.convert(collectDTO);
        res.setOwner(RequestContext.getUserId());
        res.setCover(upLoadUtils.uploadFile(collectDTO.getImg()));
        baseMapper.insert(res);
    }

    @Override
    public CollectVO get(Integer id) {
        return null;
    }
}
