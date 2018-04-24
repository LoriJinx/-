package com.system.service;

import com.system.po.User;

/**
 *
 *
 */
public interface UserloginService {

    //根据账号查找用户
    User findByAccount(String account) throws Exception;

    //根据ID查找用户
    User findByUid(int uid);

    //重置密码
    void resetPassword(int uid, String password) throws Exception;

    //保存用户登录信息
    void save(User userlogin) throws Exception;

    //根据姓名删除
    void removeByName(String name) throws Exception;

    //根据用户名更新
    void updateByName(String name, User userlogin);

}
