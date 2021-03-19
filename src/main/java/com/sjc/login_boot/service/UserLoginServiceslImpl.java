package com.sjc.login_boot.service;

import com.sjc.login_boot.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sjc.login_boot.mapper.first.UserLoginMapper;

import java.util.List;

@Service
public class UserLoginServiceslImpl implements UserLoginServicesl {
    @Autowired
    UserLoginMapper userLoginMapper;
    @Override
    public List<UserEntity> queryAll() {
        return userLoginMapper.queryAll();
    }

    @Override
    public int add(UserEntity userEntity) {
        return userLoginMapper.add(userEntity.getPassword(),userEntity.getUsername());
    }

    @Override
    public UserEntity queryByName(String username) {
        return userLoginMapper.queryByName(username);
    }

    @Override
    public UserEntity deleteByName(String username){
        return userLoginMapper.deleteByName(username);
    }

    @Override
    public  UserEntity updateByName(String username){return userLoginMapper.updateByName(username);}

}
