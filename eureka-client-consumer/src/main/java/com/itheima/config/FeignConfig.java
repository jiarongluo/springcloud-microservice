package com.itheima.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignConfig
 * @Description feign配置类：打印feign的调用过程信息
 * @Author 传智播客
 * @Date 9:55 2020/11/29
 * @Version 2.1
 **/
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        // 指定打印的日志级别
        return Logger.Level.FULL;
    }
}
