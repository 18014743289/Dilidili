package com.he.dilidili.convert;

import com.he.dilidili.model.dto.ProductsDTO;
import com.he.dilidili.model.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductsConvert {
    ProductsConvert INSTANCE = Mappers.getMapper(ProductsConvert.class);

    Products convert(ProductsDTO dto);

}