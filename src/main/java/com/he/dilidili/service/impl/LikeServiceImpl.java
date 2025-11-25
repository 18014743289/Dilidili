package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.convert.LikeConvert;
import com.he.dilidili.mapper.LikeMapper;
import com.he.dilidili.model.dto.LikeDTO;
import com.he.dilidili.model.entity.Like;
import com.he.dilidili.service.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like> implements LikeService {
    private final NewsService newsService;
    private final ProductsService productsService;
    private final CommentService commentService;
    private final DanmuService danmuService;
    @Override
    public Integer addLike(LikeDTO likeDTO) {
    // 将传入的LikeDTO对象转换为Like对象
        Like res = LikeConvert.INSTANCE.convert(likeDTO);
    // 设置当前用户的ID到Like对象中
        res.setUser(RequestContext.getUserId());
    // 将Like对象插入到数据库中，并获取插入后的ID
        int id = baseMapper.insert(res);
    // 初始化接收者的ID
        int receiver = 0;
    // 根据点赞的对象类型，获取不同的接收者ID和通知内容
        String content = switch (res.getObject()) {
            case 0 -> {
            // 如果点赞的对象是作品，获取作品的作者ID
                receiver = productsService.getById(res.getObjectId()).getAuthor();
            // 设置通知内容为“您的作品被点赞了”
                yield "您的作品被点赞了";
            }
            case 1 -> {
            // 如果点赞的对象是评论，获取评论的作者ID
                receiver = commentService.getById(res.getObjectId()).getUtterer();
            // 设置通知内容为“您的评论被点赞了”
                yield "您的评论被点赞了";
            }
            case 2 -> {
            // 如果点赞的对象是弹幕，获取弹幕的作者ID
                receiver = danmuService.getById(res.getObjectId()).getSender();
            // 设置通知内容为“您的弹幕被点赞了”
                yield "您的弹幕被点赞了";
            }
            default -> "";
        };
        newsService.addNews(receiver,0,content);
        return id;
    }

    @Override
    public void deleteLike(Integer id) {
        baseMapper.deleteById(id);
    }

    @Override
    public boolean queryLikeStatus(LikeDTO likeDTO) {
        return false;
    }
}
