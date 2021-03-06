package com.lmy.mxg.springcloud.service.impl;

import com.lmy.mxg.springcloud.entities.Product;
import com.lmy.mxg.springcloud.mapper.ProductMapper;
import com.lmy.mxg.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: com.lmy.mxg.springcloud.service.impl
 * @Description:
 * @Author: linmy
 * @Date: 2020/11/22
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public Product get(Long pid) {
        return productMapper.findById(pid);
    }

    @Override
    public List<Product> list() {
        return productMapper.findAll();
    }

    @Override
    public Boolean add(Product product) {
        return productMapper.addProduct(product);
    }
}
