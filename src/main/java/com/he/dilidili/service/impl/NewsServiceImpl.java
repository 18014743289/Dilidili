package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.mapper.NewsMapper;
import com.he.dilidili.model.entity.News;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.NewsVO;
import com.he.dilidili.service.NewsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {
    @Override
    public PageResult<NewsVO> getNewsByType(Query query) {
        return null;
    }

    @Override
    public void addNews(Integer receiver ,Integer type,String content) {
        News news = new News();
        news.setContent(content);
        news.setReceiver(receiver);
        news.setType(type);
        baseMapper.insert(news);
    }

    @Override
    public void deleteNews(Integer id) {
        baseMapper.deleteById(id);
    }
}
