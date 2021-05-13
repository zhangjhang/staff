package com.lx.service.impl;

import com.lx.mapper.UserMapper;
import com.lx.pojo.User;
import com.lx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean login(String username,String password) {
        User user = userMapper.queryUserByName(username);
        if (user==null){
            return false;
        }
        if(!password.equals(user.getPassword())){
            return false;
        }
        return true;
    }

    @Override
    public User login(String username) {
        return userMapper.queryUserByName(username);
    }

    @Override
    public boolean register(User user) {
        user.setCreateTime(new Date());
        user.setStatus(true);
        boolean b = userMapper.addUser(user);
        return b;
    }

    @Override
    public List<String> queryPerm() {
        return userMapper.queryUserPerm();
    }
}
