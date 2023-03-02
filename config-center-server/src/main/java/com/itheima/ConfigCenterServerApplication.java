package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ConfigCenterServerApplication
 * @Description
 * @Author 传智播客
 * @Date 14:48 2020/11/29
 * @Version 2.1
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer     // 开启配置中心服务
public class ConfigCenterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterServerApplication.class, args);
    }
}
