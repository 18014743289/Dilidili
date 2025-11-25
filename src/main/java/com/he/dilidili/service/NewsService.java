package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.entity.News;
import com.he.dilidili.model.query.KeyQuery;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.NewsVO;

public interface NewsService extends IService<News> {

//    筛选个人类型消息
    PageResult<NewsVO> getNewsByType(Query query);

//    添加消息
    void addNews(Integer receiver ,Integer type,String content);

//    删除消息
    void deleteNews(Integer id);
}
