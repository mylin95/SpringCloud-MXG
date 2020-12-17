package com.lmy.mxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Package: com.lmy.mxg.springcloud
 * @Description:
 * @Author: linmy
 * @Date: 2020/12/17
 */
@EnableEurekaClient
@EnableZuulProxy //开启zuul的功能
@SpringBootApplication
public class ZuulServer_7001 {
public static void main(String[] args) {
SpringApplication.run(ZuulServer_7001.class, args);
}
}