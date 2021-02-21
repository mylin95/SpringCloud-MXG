package com.lmy.mxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Package: com.lmy.mxg.springcloud
 * @Description:
 *  @EnableConfigServer: 开启配置中心功能
 * @Author: linmy
 * @Date: 2020/11/30
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServer_5001 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_5001.class, args);
    }
}
