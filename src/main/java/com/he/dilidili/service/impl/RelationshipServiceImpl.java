package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.mapper.RelationshipMapper;
import com.he.dilidili.model.entity.Relationship;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.RelationshipVO;
import com.he.dilidili.service.RelationshipService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RelationshipServiceImpl extends ServiceImpl<RelationshipMapper, Relationship> implements RelationshipService {


    @Override
    public PageResult<RelationshipVO> getFollows(Query query) {
        return null;
    }

    @Override
    public PageResult<RelationshipVO> getFans(Query query) {
        return null;
    }

    @Override
    public PageResult<RelationshipVO> getEachOther(Query query) {
        return null;
    }

    @Override
    public boolean getFollowStatus(Integer id) {
        return false;
    }

    @Override
    public void addRelationship(Integer id) {
        Relationship res = new Relationship();
        res.setFollow(id);
        res.setFan(RequestContext.getUserId());
        baseMapper.insert(res);
    }

    @Override
    public void deleteRelationship(Integer id) {
        baseMapper.deleteById(id);
    }
}
