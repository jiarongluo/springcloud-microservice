package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description
 * @Author 传智播客
 * @Date 10:29 2020/11/28
 * @Version 2.1
 **/
@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private int port;

    // http://localhost:8080/api/user/findById?id=xxx
//    @RequestMapping("/findById")
//    public User findById(Integer id)

    // RESTful  http://localhost:8080/api/user/2
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable(value = "id") Integer id){
        System.out.println("consumer调用的端口：" + port);
        return userService.findById(id);
    }

}
