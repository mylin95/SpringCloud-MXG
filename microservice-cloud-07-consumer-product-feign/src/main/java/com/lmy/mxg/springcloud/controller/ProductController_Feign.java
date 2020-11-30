package com.lmy.mxg.springcloud.controller;

import com.lmy.mxg.springcloud.entities.Product;
import com.lmy.mxg.springcloud.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Package: com.lmy.mxg.springcloud.controller
 * @Description:
 * @Author: linmy
 * @Date: 2020/11/22
 */
@RestController
public class ProductController_Feign {

    @Autowired
    private ProductClientService service;

    @PostMapping(value = "/consumer/product/add")
    public boolean add(@RequestBody Product product) {
        return service.add(product);
    }

    @GetMapping(value = "/consumer/product/get/{id}")
    public Product get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping(value = "/consumer/product/list")
    public List<Product> list() {
        return service.list();
    }

}
