package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.dto.ChatDTO;
import com.he.dilidili.model.entity.Chat;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.ChatVO;

public interface ChatService extends IService<Chat> {

//    获取单对象聊天记录
    PageResult<ChatVO> getPage(Query query);

//    获取聊天记录
    PageResult<ChatVO> getChat(Query query);

//    发送消息
    void send(ChatDTO chatDTO);

//    撤回消息
    void withdraw(Integer id);
}
