package com.lmy.mxg.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Package: com.lmy.mxg.springcloud
 * @Description:
 * @Author: linmy
 * @Date: 2020/11/22
 */
@EnableEurekaClient
@MapperScan("com.lmy.mxg.springcloud.mapper")
@SpringBootApplication
public class ProductProvider_Config_8001 {

    public static void main(String[] args) {
        SpringApplication.run(ProductProvider_Config_8001.class, args);
    }
}
