package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.model.dto.LikeDTO;
import com.he.dilidili.model.entity.Like;

public interface LikeService extends IService<Like> {

//    点赞
    Integer addLike(LikeDTO likeDTO);

//    取消点赞
    void deleteLike(Integer id);

//    查询点赞状态
    boolean queryLikeStatus(LikeDTO likeDTO);

}
