package com.itheima.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConsumerController
 * @Description
 * @Author 传智播客
 * @Date 10:50 2020/11/28
 * @Version 2.1
 **/
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "allFallBack") // 针对所有的方法进行熔断
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findById/{id}")
//    @HystrixCommand(fallbackMethod = "findByIdFallBackMethod")    // 熔断（兜底）方法
    @HystrixCommand    // 熔断（兜底）方法，类上的熔断方法生效，在本方法中不能加熔断方法
    public String findById(@PathVariable(value = "id") Integer id){
//        String url = "http://localhost:9091/api/user/findById/" + id;
        String url = "http://eureka-client-provider/api/user/findById/" + id;
        // RestTemplate调用
        String json = restTemplate.getForObject(url, String.class);
        return json;
    }

//    @GetMapping("/findAll")
//    @PutMapping("/update")
//    @PostMapping("/save")

    public String findByIdFallBackMethod(Integer id){
        // TODO 自己构造一些json数据

        return "提供方睡着了...";
    }

    public String allFallBack(){
        return "服务器宕机了...";
    }
}
