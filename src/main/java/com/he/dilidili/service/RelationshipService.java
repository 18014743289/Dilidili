package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.entity.Relationship;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.RelationshipVO;

public interface RelationshipService extends IService<Relationship> {

//    获取关注
    PageResult<RelationshipVO> getFollows(Query query);

//    获取粉丝
    PageResult<RelationshipVO> getFans(Query query);

//    获取互相关注
    PageResult<RelationshipVO> getEachOther(Query query);

//    获取关注状态
    boolean getFollowStatus(Integer id);

//    关注
    void addRelationship(Integer id);

//    取消关注
    void deleteRelationship(Integer id);
}
