package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.model.dto.ProductsDTO;
import com.he.dilidili.model.entity.Products;
import com.he.dilidili.model.query.KeyQuery;
import com.he.dilidili.model.vo.ProductsVO;

public interface ProductsService extends IService<Products> {

    //    获取作品信息
    ProductsVO getProducts(Integer id);

    //    修改作品信息
    void updateProducts(ProductsDTO productsDTO);

    //    添加作品信息
    void addProducts(ProductsDTO productsDTO);

    //    删除作品信息
    void deleteProducts(Integer id);

    //    模糊搜索
    PageResult<ProductsVO> searchProducts(KeyQuery keyQuery);

    ProductsVO[] getProductsByAuthorId(Integer id);

}
