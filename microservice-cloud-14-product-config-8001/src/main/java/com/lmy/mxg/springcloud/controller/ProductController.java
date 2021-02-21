package com.lmy.mxg.springcloud.controller;

import com.lmy.mxg.springcloud.entities.Product;
import com.lmy.mxg.springcloud.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Package: com.lmy.mxg.springcloud.controller
 * @Description:
 *  @RefreshScope: 刷新配置中心的配置
 * @Author: linmy
 * @Date: 2020/11/22
 */
@RefreshScope
@RestController
public class ProductController {

    @Value("${emp.name}")
    private String name;

    @GetMapping("/hello")
    public Object hello() {
        return name;
    }

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "添加商品", notes = "添加商品")
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {
        return productService.get(id);
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.list();
    }

}
