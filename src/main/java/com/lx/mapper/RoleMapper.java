package com.lx.mapper;

import com.lx.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    List<Role> queryRoleAll();

    List<String> queryRole();
}
