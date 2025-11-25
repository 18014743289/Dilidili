package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.model.dto.CoinDTO;
import com.he.dilidili.model.entity.Coin;

public interface CoinService extends IService<Coin> {

//    查询投币记录
    Integer isCoin(Integer product);

//    投币
    void coin(CoinDTO coinDTO);

}
