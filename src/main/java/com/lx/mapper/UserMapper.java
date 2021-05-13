package com.lx.mapper;

import com.lx.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    //根据用户名查询用户
    User queryUserByName(String username);

    //提交用户
    boolean addUser(User user);

    //查询全部权限
    List<String> queryUserPerm();

}
