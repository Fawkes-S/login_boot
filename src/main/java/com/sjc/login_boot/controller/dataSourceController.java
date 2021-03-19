package com.sjc.login_boot.controller;

import com.sjc.login_boot.entity.SecondEntity;
import com.sjc.login_boot.entity.UserEntity;
import com.sjc.login_boot.mapper.first.UserLoginMapper;
import com.sjc.login_boot.mapper.second.SecondLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/multidb")
public class dataSourceController {
    @Autowired
    private UserLoginMapper userLoginMapper;
    @Autowired
    private SecondLoginMapper secondLoginMapper;

    @GetMapping("/getfirst")
    public List<UserEntity> getFirst(){
        return userLoginMapper.queryAll();
    }
    @GetMapping("/getsecond")
    public List<SecondEntity> getSecond(){
        return secondLoginMapper.queryAll();
    }


}
