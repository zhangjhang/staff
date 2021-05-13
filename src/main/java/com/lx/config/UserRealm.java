package com.lx.config;

import com.lx.pojo.User;
import com.lx.service.RoleService;
import com.lx.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) subject.getPrincipal();


        if("超级管理员".equals(principal.getPerm())){
            List<String> perms = new ArrayList<>();
            List<String> roles = new ArrayList<>();
            List<String> strings = userService.queryPerm();

            perms.addAll(strings);
            roles.addAll(roleService.queryRole());

            info.addStringPermissions(perms);

            //


            info.addRoles(roles);


        }else {
            info.addStringPermission(principal.getPerm());
        }



//        info.addRole("u");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        token.getUsername();
        User user = userService.login(token.getUsername());
        if (user==null){
            return null;
        }
//
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
//        return null;
    }
}
