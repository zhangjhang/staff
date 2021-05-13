package com.lx.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);
        Map<String,String> map = new LinkedHashMap<>();

        map.put("/login","anon");
        map.put("/toAdmin","perms[超级管理员]");
        map.put("/user","perms[普通用户],roles[java工程师]");
        map.put("/toAdmins","perms[管理员]");

//        map.put("/user","roles[普通用户]");

        bean.setFilterChainDefinitionMap(map);


        bean.setLoginUrl("/toLogin");

        bean.setUnauthorizedUrl("/unauth");
        return bean;

    }


    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    @Bean
    public UserRealm getUserRealm(){
        return new UserRealm();
    }


}
