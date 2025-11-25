package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.mapper.LayoutMapper;
import com.he.dilidili.model.entity.Layout;
import com.he.dilidili.service.LayoutService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class LayoutServiceImpl extends ServiceImpl<LayoutMapper, Layout> implements LayoutService {
}
