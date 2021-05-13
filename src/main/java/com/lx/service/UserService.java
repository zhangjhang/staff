package com.lx.service;

import com.lx.pojo.User;

import java.util.List;


public interface UserService {

    //登录
    Boolean login(String username,String password);
    //shiro登录
    User login(String username);

    //注册
    boolean register(User user);

    //查询全部权限
    List<String> queryPerm();
}
