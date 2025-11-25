package com.he.dilidili.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.dto.CommentDTO;
import com.he.dilidili.model.entity.Comment;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.CommentVO;

public interface CommentService extends IService<Comment> {

//    查询视频评论
    PageResult<CommentVO> getPage(Query query);

//    查询二级评论
    PageResult<CommentVO> getSecondPage(Query query);

//    添加评论
    void addComment(CommentDTO commentDTO);

//    删除评论
    void deleteComment(Integer id);

}
