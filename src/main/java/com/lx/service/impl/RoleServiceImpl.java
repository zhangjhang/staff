package com.lx.service.impl;

import com.lx.mapper.RoleMapper;
import com.lx.pojo.Role;
import com.lx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryRoleAll() {
        return roleMapper.queryRoleAll();
    }

    @Override
    public List<String> queryRole() {
        return roleMapper.queryRole();
    }
}
