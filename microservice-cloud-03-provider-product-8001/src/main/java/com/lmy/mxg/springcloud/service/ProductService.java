package com.lmy.mxg.springcloud.service;

import com.lmy.mxg.springcloud.entities.Product;

import java.util.List;

/**
 * @Package: com.lmy.mxg.springcloud.service
 * @Description:
 * @Author: linmy
 * @Date: 2020/11/22
 */
public interface ProductService {
    Product get(Long pid);

    List<Product> list();

    Boolean add(Product product);
}
