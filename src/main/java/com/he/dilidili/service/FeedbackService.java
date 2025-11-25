package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.dto.FeedbackDTO;
import com.he.dilidili.model.entity.Feedback;
import com.he.dilidili.model.query.KeyQuery;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.FeedbackVO;

public interface FeedbackService extends IService<Feedback> {

//    查询所有反馈
    PageResult<FeedbackVO> getAllFeedback(Query query);

//    根据状态筛选反馈
    PageResult<FeedbackVO> getFeedbackByStatus(Query query);

//    根据内容模糊搜索
    PageResult<FeedbackVO> searchFeedback(KeyQuery keyQuery);

//    添加反馈
    void addFeedback(FeedbackDTO feedbackDTO);

//    更新反馈状态
    void updateFeedbackStatus(Integer id, Integer status);
}
