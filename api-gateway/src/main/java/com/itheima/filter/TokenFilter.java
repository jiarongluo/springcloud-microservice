package com.itheima.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName TokenFilter
 * @Description 全局过滤器
 * @Author 传智播客
 * @Date 11:17 2020/11/29
 * @Version 2.1
 **/
@Component
public class TokenFilter implements GlobalFilter, Ordered{

    /**
     * @author 栗子
     * @Description 判断用户是否登录  判断访问时是否携带token
     * @Date 11:19 2020/11/29
     * @param exchange 包含了req和res
     * @param chain    链   过滤器链
     * @return reactor.core.publisher.Mono<java.lang.Void>  webflux编程
     **/
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取request和response
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        // 获取请求的参数值
        // http://ip:port/xxx?token=xxx
        String token = request.getQueryParams().getFirst("token");
        if (StringUtils.isEmpty(token)){
            System.out.println("token is empty, please login...");

            // 不能放行
            response.setStatusCode(HttpStatus.UNAUTHORIZED);    // 响应状态码：未认证
            return response.setComplete();
        }

        return chain.filter(exchange);
    }

    /**
     * @author 栗子
     * @Description 用来指定过滤器的执行优先级（顺序）  值越小（不为负数），优先级越高
     * @Date 11:18 2020/11/29
     * @param
     * @return int
     **/
    @Override
    public int getOrder() {
        return 0;
    }
}
