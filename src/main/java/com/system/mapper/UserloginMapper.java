package com.system.mapper;

import com.system.po.User;
import com.system.po.UserloginExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserloginMapper {
    int countByExample(UserloginExample example);

    int deleteByExample(UserloginExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserloginExample example);

    @Select("select uid,account,role,password from users where account=#{account}")
    User selectByAccount(@Param("account") String account);

    @Select("select uid,account,password from users where uid=#{uid}")
    User selectByUid(@Param("uid") int uid);

    @Update("update users set password=#{password} where uid=#{uid}")
    int updatePasswordByUid(@Param("uid") int uid, @Param("password") String password);
    User selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserloginExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserloginExample example);


    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}