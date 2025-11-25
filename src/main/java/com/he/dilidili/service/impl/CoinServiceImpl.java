package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.mapper.CoinMapper;
import com.he.dilidili.model.dto.CoinDTO;
import com.he.dilidili.model.entity.Coin;
import com.he.dilidili.service.CoinService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CoinServiceImpl extends ServiceImpl<CoinMapper, Coin> implements CoinService {
    @Override
    public Integer isCoin(Integer product) {
        return null;
    }

    @Override
    public void coin(CoinDTO coinDTO) {

    }
}
