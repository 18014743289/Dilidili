package com.he.dilidili.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.convert.CollectionsConvert;
import com.he.dilidili.convert.CommentConvert;
import com.he.dilidili.mapper.CommentMapper;
import com.he.dilidili.model.dto.CommentDTO;
import com.he.dilidili.model.entity.Comment;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.CommentVO;
import com.he.dilidili.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public PageResult<CommentVO> getPage(Query query) {
        return null;
    }

    @Override
    public PageResult<CommentVO> getSecondPage(Query query) {
        return null;
    }

    @Override
    public void addComment(CommentDTO commentDTO) {
        Comment res = CommentConvert.INSTANCE.convert(commentDTO);
        res.setUtterer(RequestContext.getUserId());
        res.setCreateTime(LocalDateTime.now());
        baseMapper.insert(res);
    }

    @Override
    public void deleteComment(Integer id) {

    }

}
                                                                                