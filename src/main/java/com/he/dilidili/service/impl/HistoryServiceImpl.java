package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.mapper.HistoryMapper;
import com.he.dilidili.model.entity.History;
import com.he.dilidili.service.HistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, History> implements HistoryService {
}
