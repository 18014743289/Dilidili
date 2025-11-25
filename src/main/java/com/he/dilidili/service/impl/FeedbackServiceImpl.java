package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.mapper.FeedbackMapper;
import com.he.dilidili.model.dto.FeedbackDTO;
import com.he.dilidili.model.entity.Feedback;
import com.he.dilidili.model.query.KeyQuery;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.FeedbackVO;
import com.he.dilidili.service.FeedbackService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {
    @Override
    public PageResult<FeedbackVO> getAllFeedback(Query query) {
        return null;
    }

    @Override
    public PageResult<FeedbackVO> getFeedbackByStatus(Query query) {
        return null;
    }

    @Override
    public PageResult<FeedbackVO> searchFeedback(KeyQuery keyQuery) {
        return null;
    }

    @Override
    public void addFeedback(FeedbackDTO feedbackDTO) {

    }

    @Override
    public void updateFeedbackStatus(Integer id, Integer status) {

    }
}
