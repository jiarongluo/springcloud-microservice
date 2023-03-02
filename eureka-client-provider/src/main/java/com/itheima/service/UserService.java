package com.itheima.service;

import com.itheima.pojo.User;

/**
 * @ClassName UserService
 * @Description
 * @Author 传智播客
 * @Date 10:28 2020/11/28
 * @Version 2.1
 **/
public interface UserService {

    User findById(Integer id);
}
