package com.sjc.login_boot.mapper;

import com.sjc.login_boot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserLoginMapper {
    //查询
    public List<UserEntity> queryAll();
    //添加数据
    public int add(String password,String username);
    //根据用户名查询数据
    public UserEntity queryByName(String username);
    //删除用户
    public UserEntity deleteByName(String username);
    //修改用户
    public UserEntity updateByName(String username);


}
