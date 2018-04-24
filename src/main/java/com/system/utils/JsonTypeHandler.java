package com.system.utils;

import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JsonTypeHandler implements TypeHandler<JSONArray> {

    public void setParameter(PreparedStatement preparedStatement, int i, JSONArray jsonArray, JdbcType jdbcType) throws SQLException {

        preparedStatement.setString(i, jsonArray.toString());
    }

    public JSONArray getResult(ResultSet resultSet, String s) throws SQLException {

        return JSONArray.parseArray(resultSet.getString(s));
    }

    public JSONArray getResult(ResultSet resultSet, int i) throws SQLException {

        return JSONArray.parseArray(resultSet.getString(i));
    }

    public JSONArray getResult(CallableStatement callableStatement, int i) throws SQLException {

        return JSONArray.parseArray(callableStatement.getString(i));
    }
}
