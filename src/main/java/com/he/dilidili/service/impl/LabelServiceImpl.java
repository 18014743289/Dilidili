package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.mapper.LabelMapper;
import com.he.dilidili.model.entity.Label;
import com.he.dilidili.service.LabelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements LabelService {
}
