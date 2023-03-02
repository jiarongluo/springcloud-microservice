package com.itheima.feign;

import org.springframework.stereotype.Component;

/**
 * @ClassName UserFeignFallBack
 * @Description 对每个单独的方法进行兜底
 * @Author 传智播客
 * @Date 9:50 2020/11/29
 * @Version 2.1
 **/
@Component
public class UserFeignFallBack implements UserFeign {

    @Override
    public String findById(Integer id) {
        return "调用provider失败...";
    }
}
