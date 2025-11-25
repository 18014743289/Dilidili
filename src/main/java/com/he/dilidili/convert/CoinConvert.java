package com.he.dilidili.convert;

import com.he.dilidili.model.dto.CoinDTO;
import com.he.dilidili.model.entity.Coin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CoinConvert {
    CoinConvert INSTANCE = Mappers.getMapper(CoinConvert.class);

    Coin convert(CoinDTO dto);

}