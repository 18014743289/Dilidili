package com.he.dilidili.convert;

import com.he.dilidili.model.entity.News;
import com.he.dilidili.model.vo.NewsVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsConvert {
    NewsConvert INSTANCE = Mappers.getMapper(NewsConvert.class);

    NewsVO convert(News news);

}