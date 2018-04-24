package com.system.service.impl;

import com.system.exception.CustomException;
import com.system.mapper.UserloginMapper;
import com.system.po.User;
import com.system.po.UserloginExample;
import com.system.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserloginServiceImpl implements UserloginService {

    @Autowired
    private UserloginMapper userloginMapper;

    public User findByAccount(String account) throws Exception{

        User queryResult = userloginMapper.selectByAccount(account);
        return queryResult;
    }

    public User findByUid(int uid){
        return userloginMapper.selectByUid(uid);
    }

    public void resetPassword(int uid, String password) throws Exception {
        if (userloginMapper.updatePasswordByUid(uid, password) != 1){
            throw new Exception("检查你的ID!");
        }
    }


    public void save(User userlogin) throws Exception {
        userloginMapper.insert(userlogin);
    }

    public void removeByName(String name) throws Exception {
        UserloginExample userloginExample = new UserloginExample();

        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userloginMapper.deleteByExample(userloginExample);
    }

    public void updateByName(String name, User userlogin) {
        UserloginExample userloginExample = new UserloginExample();

        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userloginMapper.updateByExample(userlogin, userloginExample);
    }

}
