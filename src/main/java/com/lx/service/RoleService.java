package com.lx.service;

import com.lx.pojo.Role;

import java.util.List;

public interface RoleService {

    List<Role> queryRoleAll();
    List<String> queryRole();

}
