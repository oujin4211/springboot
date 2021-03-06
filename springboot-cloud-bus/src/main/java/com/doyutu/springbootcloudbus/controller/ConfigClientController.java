package com.doyutu.springbootcloudbus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * POST调用 http://{url}:{port}/refresh 实现数据热加载
 * POST调用 http://{url}:{port}/bus/refresh 实现同步数据加载
 * POST调用 http://{url}:{port}/bus/refresh?destination={serviceId}:{servicePort} 实现选择性数据加载
 * 如调用出现 401 错误，Unauthorized
 * 需要关闭security安全模块
 */

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${profile}")
    private String profile;

    @GetMapping("/hello")
    public String hello() {
        return this.profile;
    }
}
