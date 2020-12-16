package com.lmy.mxg.springcloud.service;

import com.lmy.mxg.springcloud.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Package: com.lmy.mxg.springcloud.service
 * @Description:
 *  熔断处理类: 服务宕机时，使用的处理类，对应方法处理调用
 * @Author: linmy
 * @Date: 2020/12/16
 */
@Component
public class ProductClientServiceFallBack implements ProductClientService{
    @Override
    public Product get(Long id) {
        return new Product(id, "ID=" + id + "无效----@HystrixCommand", "无法找到对应的数据库");
    }

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public boolean add(Product product) {
        return false;
    }
}
