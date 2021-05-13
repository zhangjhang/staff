package com.lx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/toAdmin")
    public String admin(){
        return "admin/admin";
    }

    @RequestMapping("/toAdmins")
    public String admins(){
        return "admin/admins";
    }

    @RequestMapping("/user")
    public String user(){
        return "admin/user";
    }

    @RequestMapping("/unauth")
    @ResponseBody
    public String unauth(){
        return "未经授权";
    }

}
