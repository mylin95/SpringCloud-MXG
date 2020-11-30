package com.lmy.mxg.springcloud.service;
import com.lmy.mxg.springcloud.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

/**
 * @Package: com.lmy.mxg.springcloud.service
 * @Description:
 *  SpringCloud对Feign进行了增强兼容了SpringMVC的注解 ，我们在使用SpringMVC的注解时需要注意：
 * 1、@FeignClient接口方法有基本类型参数在参数必须加@PathVariable("XXX") 或 @RequestParam("XXX")
 * 2、@FeignClient接口方法返回值为复杂对象时，此类型必须有无参构造方法。
 * @Author: linmy
 * @Date: 2020/11/30
 */
//指定调用的服务 MICROSERVICE-PRODUCT
@FeignClient(value = "MICROSERVICE-PRODUCT")
public interface ProductClientService {

    @RequestMapping(value = "/product/get/{id}",method = RequestMethod.GET)
    Product get(@PathVariable(value = "id") Long id);

    @RequestMapping(value = "/product/list",method = RequestMethod.GET)
    List<Product> list();

    @RequestMapping(value = "/product/add",method = RequestMethod.POST)
    boolean add(Product product);
}