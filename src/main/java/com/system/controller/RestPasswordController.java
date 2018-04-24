package com.system.controller;

import com.system.exception.CustomException;
import com.system.po.User;
import com.system.service.UserloginService;
import com.system.utils.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class RestPasswordController {

    @Resource(name = "userloginServiceImpl")
    private UserloginService userloginService;

    // 本账户密码重置
    @RequestMapping(value = "/passwordRest", method = {RequestMethod.POST})
    public String passwordRest(String oldPassword, String password1) throws Exception {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        user = userloginService.findByUid(user.getUid());
        if (!user.getPassword().equals(MD5.encode(oldPassword))) {
            throw new CustomException("旧密码不正确");
        } else {
            userloginService.resetPassword(user.getUid(), MD5.encode(password1));
        }

        return "redirect:/logout";
    }

}
