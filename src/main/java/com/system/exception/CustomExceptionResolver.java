package com.system.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *    全局异常处理器
 *    springmvc提供一个HandlerExceptionResolver接口
 *      只要实现该接口，并配置到spring 容器里，该类就能
 *      成为默认全局异常处理类
 *
 *   全局异常处理器只有一个，配置多个也没用。
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        String message = "";
        ModelAndView modelAndView = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        CustomException customException;
        if (e instanceof CustomException) {
            message = e.getMessage();
        } else if (e instanceof UnknownAccountException) {
            //用户名错误异常
            message = "用户名不存在！";
        } else if (e instanceof IncorrectCredentialsException) {
            //用户名错误异常
            message = "密码错误！";
        } else {
            message = "未知错误";
            modelAndView.addObject("message", message);
            modelAndView.setViewName("error");
            return modelAndView;
        }

        //错误信息
        Map<String, String> errorInfo = new HashMap<>();
        errorInfo.put("message", message);
        view.setAttributesMap(errorInfo);
        modelAndView.setView(view);


        return modelAndView;
    }
}
