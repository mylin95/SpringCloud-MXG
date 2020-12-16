package com.lmy.mxg.springcloud.mapper;

import com.lmy.mxg.springcloud.entities.Product;

import java.util.List;

/**
 * @Package: com.lmy.mxg.springcloud.mapper
 * @Description:
 * 启动类上使用 @MapperScan("com.lmy.mxg.springcloud.mapper") 后，具体Mapper类上就不需要 @Mapper 注解了
 * @Author: linmy
 * @Date: 2020/11/22
 */
// @Mapper //
public interface ProductMapper {

    Product findById(Long pid);

    List<Product> findAll();

    Boolean addProduct(Product product);
}
