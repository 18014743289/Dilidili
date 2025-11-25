package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.mapper.ProductsMapper;
import com.he.dilidili.model.entity.Products;
import com.he.dilidili.service.ProductsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsService {
}
