package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.mapper.ChatMapper;
import com.he.dilidili.model.dto.ChatDTO;
import com.he.dilidili.model.entity.Chat;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.ChatVO;
import com.he.dilidili.service.ChatService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat> implements ChatService {
    @Override
    public PageResult<ChatVO> getPage(Query query) {
        return null;
    }

    @Override
    public PageResult<ChatVO> getChat(Query query) {
        return null;
    }


    @Override
    public void send(ChatDTO chatDTO) {

    }

    @Override
    public void withdraw(Integer id) {

    }
}
