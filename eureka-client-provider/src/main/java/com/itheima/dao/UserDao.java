package com.itheima.dao;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName UserDao
 * @Description
 * @Author 传智播客
 * @Date 10:27 2020/11/28
 * @Version 2.1
 **/
@Mapper
public interface UserDao {

    @Select("select * from tb_user where id = #{id}")
    User findById(Integer id);
}
