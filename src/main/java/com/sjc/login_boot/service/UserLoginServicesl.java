package com.sjc.login_boot.service;

import com.sjc.login_boot.entity.UserEntity;

import java.util.List;

public interface UserLoginServicesl {
    //查询
    public List<UserEntity> queryAll();
    //添加数据
    public int add(UserEntity UserEntity);
    //根据用户名查询数据
    public UserEntity queryByName(String username);
    //删除用户
    public UserEntity deleteByName(String username);
    //修改用户
    public UserEntity updateByName(String username);
}


