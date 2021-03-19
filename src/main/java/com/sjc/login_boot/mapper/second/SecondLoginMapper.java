package com.sjc.login_boot.mapper.second;

import com.sjc.login_boot.entity.SecondEntity;
import com.sjc.login_boot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SecondLoginMapper {
    //查询
    public List<SecondEntity> queryAll();
}
