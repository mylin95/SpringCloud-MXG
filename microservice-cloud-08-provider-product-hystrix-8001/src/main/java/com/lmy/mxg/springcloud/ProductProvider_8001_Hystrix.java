package com.lmy.mxg.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Package: com.lmy.mxg.springcloud
 * @Description:
 * @Author: linmy
 * @Date: 2020/11/22
 */
@EnableHystrix // 开启Hystrix的熔断机制
@EnableEurekaClient
@MapperScan("com.lmy.mxg.springcloud.mapper")
@SpringBootApplication
public class ProductProvider_8001_Hystrix {

    public static void main(String[] args) {
        SpringApplication.run(ProductProvider_8001_Hystrix.class, args);
    }
}
