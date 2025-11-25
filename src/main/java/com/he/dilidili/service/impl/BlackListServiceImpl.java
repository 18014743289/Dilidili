package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.mapper.BlackListMapper;
import com.he.dilidili.model.dto.BlackListDTO;
import com.he.dilidili.model.entity.BlackList;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.BlackListVO;
import com.he.dilidili.service.BlackListService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class BlackListServiceImpl extends ServiceImpl<BlackListMapper, BlackList> implements BlackListService {
    @Override
    public PageResult<BlackListVO> getPage(Query query) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void insert(BlackListDTO blackListDTO) {

    }
}
