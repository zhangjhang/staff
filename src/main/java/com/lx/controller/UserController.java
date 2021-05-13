package com.lx.controller;

import com.lx.mapper.UserMapper;
import com.lx.pojo.User;
import com.lx.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model, HttpSession session){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            session.setAttribute("user",username);
            return "admin/index";
        } catch (UnknownAccountException e) {
            model.addAttribute("err","用户名不存在");
            return "login";
        }


//        if(username==null && username.length()<=0){
//            System.out.println(1);
//            model.addAttribute("err","用户名或密码不能为空");
//
//            return "login";
//        }
//
//        Boolean login = userService.login(username,password);
//        if(!login){
//            model.addAttribute("err","用户名或密码错误");
//            return "login";
//        }
//        session.setAttribute("loginUser",username);
//        return "admin/index";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(User user){

        boolean register = userService.register(user);
        System.out.println(register);

        return "redirect:/toLogin";
    }
}
