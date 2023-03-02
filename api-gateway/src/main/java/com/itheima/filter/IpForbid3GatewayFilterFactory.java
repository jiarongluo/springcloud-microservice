package com.itheima.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName IpForbidGatewayFilterFactory
 * @Description 自定义局部过滤器
 * @Author 传智播客
 * @Date 11:49 2020/11/29
 * @Version 2.1
 **/
@Component
public class IpForbid3GatewayFilterFactory extends AbstractGatewayFilterFactory<IpForbid3GatewayFilterFactory.Config> {

    /**
     * @author 栗子
     * @Description 构造方法
     * @Date 11:51 2020/11/29
     * @param
     * @return
     **/
    public IpForbid3GatewayFilterFactory() {
        super(Config.class);
    }

    // 还需要实现另外一个方法
    /**
     * @author 栗子
     * @Description 指定属性的加载顺序
     * @Date 12:00 2020/11/29
     * @param
     * @return java.util.List<java.lang.String>
     **/
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("ip");
    }

    /**
     * @author 栗子
     * @Description 判断是否是同一个ip
     * @Date 11:52 2020/11/29
     * @param config
     * @return org.springframework.cloud.gateway.filter.GatewayFilter
     **/
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            System.out.println("IpForbid3...");
            // 获取req和res
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            // 获取访问当前程序的ip地址
            String hostAddress = request.getRemoteAddress().getAddress().getHostAddress();
            System.out.println("hostAddress:" + hostAddress);
            // 判断该hostAddress与我们配置的ip是否一致
            String ip = config.getIp(); // 配置的ip
            if (hostAddress.equals(ip)){
                // 同一个ip，放行
                return chain.filter(exchange);
            }
            // 不是同一个ip，不放行
            response.setStatusCode(HttpStatus.FORBIDDEN);   // 设置响应的状态码：拒绝访问
            return response.setComplete();
        };
    }

    /**
     * @author 栗子
     * @Description 配置类
     * @Date 11:50 2020/11/29
     * @return
     **/
    public static class Config {
        private String ip;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }


}
