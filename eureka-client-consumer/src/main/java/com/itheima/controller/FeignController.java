package com.itheima.controller;

import com.itheima.feign.UserFeign;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConsumerController
 * @Description
 * @Author 传智播客
 * @Date 10:50 2020/11/28
 * @Version 2.1
 **/
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired(required = false)
    private UserFeign userFeign;

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable(value = "id") Integer id){
        String json = userFeign.findById(id);
        return json;
    }

}
