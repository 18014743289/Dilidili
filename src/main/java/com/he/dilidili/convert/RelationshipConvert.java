package com.he.dilidili.convert;

import com.he.dilidili.model.entity.Relationship;
import com.he.dilidili.model.vo.RelationshipVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RelationshipConvert {
    RelationshipConvert INSTANCE = Mappers.getMapper(RelationshipConvert.class);

    RelationshipVO convert(Relationship relationship);

}