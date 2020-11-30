package com.lmy.mxg.springcloud.controller;

import com.lmy.mxg.springcloud.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Package: com.lmy.mxg.springcloud.controller
 * @Description:
 * @Author: linmy
 * @Date: 2020/11/22
 */
@RestController
public class ProductController_Consumer {

    // private static final String REST_URL_PREFIX = "http://127.0.0.1:8001";
    /** 修改为Eureka注册中心的地址 */
    private static final String REST_URL_PREFIX = "http://MICROSERVICE-PRODUCT";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/product/add")
    public Boolean add(Product product) {
        String url = REST_URL_PREFIX + "/product/add";
        return restTemplate.postForObject(url, product, Boolean.class);
    }

    @GetMapping("/consumer/product/get/{id}")
    public Product get(@PathVariable("id") Long id) {
        String url = REST_URL_PREFIX + "/product/get/" + id;
        return restTemplate.getForObject(url, Product.class);
    }

    @GetMapping("/consumer/product/list")
    public List<Product> list() {
        String url = REST_URL_PREFIX + "/product/list";
        return restTemplate.getForObject(url, List.class);
    }


}
