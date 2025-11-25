package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.convert.ProductsConvert;
import com.he.dilidili.mapper.ProductsMapper;
import com.he.dilidili.model.dto.ProductsDTO;
import com.he.dilidili.model.entity.Products;
import com.he.dilidili.model.query.KeyQuery;
import com.he.dilidili.model.vo.ProductsVO;
import com.he.dilidili.service.ProductsService;
import com.he.dilidili.utils.UpLoadUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsService {
    UpLoadUtils upLoadUtils;
    @Override
    public ProductsVO getProducts(Integer id) {
        return null;
    }

    @Override
    public void updateProducts(ProductsDTO productsDTO) {
        Products res = ProductsConvert.INSTANCE.convert(productsDTO);
        baseMapper.updateById(res);
    }

    @Override
    public void addProducts(ProductsDTO productsDTO) {
        Products res = ProductsConvert.INSTANCE.convert(productsDTO);
        res.setCover(upLoadUtils.uploadFile(productsDTO.getImg()));
        res.setLink(upLoadUtils.uploadFile(productsDTO.getProduct()));
        baseMapper.insert(res);
    }

    @Override
    public void deleteProducts(Integer id) {

    }

    @Override
    public PageResult<ProductsVO> searchProducts(KeyQuery keyQuery) {
        return null;
    }

    @Override
    public ProductsVO[] getProductsByAuthorId(Integer id) {
//        TODO
        return baseMapper.selectJoinList(new MPJLambdaWrapper<>()).toArray(new ProductsVO[0]);
    }

}
