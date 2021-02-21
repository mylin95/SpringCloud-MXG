package com.lmy.mxg.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.lmy.mxg.springcloud.controller
 * @Description:
 * @Author: linmy
 * @Date: 2021/2/13
 */
@RestController
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/config")
    public String configInfo() {
        String content = "spring.application.name = " + applicationName + ", server.port = " + serverPort;
        System.out.println(content);
        return content;
    }

}
