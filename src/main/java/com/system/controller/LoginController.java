package com.system.controller;

import com.system.po.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginUI() throws Exception {
        return "../. ./login";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public String login(User user) throws Exception {

        //Shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(),
                user.getPassword());
        Subject subject = SecurityUtils.getSubject();

        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        subject.login(token);

        if (subject.hasRole("admin")) {
            return "/admin/showStudent";
        } else if (subject.hasRole("teacher")) {
            return "/teacher/showClasses";
        } else if (subject.hasRole("student")) {
            return "/student/showCourse";
        }

        return "/login";
    }

}
