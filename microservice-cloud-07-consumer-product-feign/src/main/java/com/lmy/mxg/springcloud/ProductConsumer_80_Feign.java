package com.lmy.mxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Package: com.lmy.mxg.springcloud
 * @Description:
 * @Author: linmy
 * @Date: 2020/11/22
 */
//会扫描标记了指定包下@FeignClient注解的接口，并生成此接口的代理对象
@EnableFeignClients(basePackages= {"com.lmy.mxg.springcloud.service"})
@EnableEurekaClient //标识Eureka客户端
@SpringBootApplication
public class ProductConsumer_80_Feign {

    public static void main(String[] args) {
        SpringApplication.run(ProductConsumer_80_Feign.class, args);
    }
}
