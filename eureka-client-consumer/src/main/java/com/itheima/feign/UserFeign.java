package com.itheima.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName UserFeign
 * @Description
 * @Author 传智播客
 * @Date 9:16 2020/11/29
 * @Version 2.1
 **/
@FeignClient(name = "eureka-client-provider", fallback = UserFeignFallBack.class)   // name：指定调用的服务名称
public interface UserFeign {

    // http://eureka-client-provider/xxxx/xxx
    @GetMapping("/api/user/findById/{id}")
    String findById(@PathVariable(value = "id") Integer id);
}
