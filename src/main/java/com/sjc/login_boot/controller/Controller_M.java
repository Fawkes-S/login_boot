package com.sjc.login_boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.sjc.login_boot.annotation.AuthToken;
import com.sjc.login_boot.entity.UserEntity;
import com.sjc.login_boot.kit.ConstantKit;
import com.sjc.login_boot.kit.Md5TokenGenerator;
import com.sjc.login_boot.model.ResponseTemplate;
import com.sjc.login_boot.service.UserLoginServiceslImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.List;

@Controller
@ResponseBody
@Api(tags = "用户接口")
public class Controller_M {
    @Autowired
    UserLoginServiceslImpl userLoginServicesl;

    @Autowired
    Md5TokenGenerator tokenGenerator;

    @ApiOperation("用户登陆的接口")
    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "login_m";
    }

    @RequestMapping("/LoginSuccess")
    public String LoginSuccess(Model model, UserEntity userEntity){
        //Token
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        List<UserEntity> users = userLoginServicesl.queryAll();
        UserEntity currentUser = users.get(0);
        JSONObject result = new JSONObject();
        //====
        //先查询看该用户名是否存在
        UserEntity userEntity1 = userLoginServicesl.queryByName(userEntity.getUsername());
        if(userEntity1 != null){ //  如果查询的用户不为空
            System.out.println(userEntity1.toString());
            System.out.println(userEntity.getPassword());//前端取到的密码
            if(userEntity1.getPassword().equals(userEntity.getPassword())){
                if(currentUser != null){
                    Jedis jedis = new Jedis("localhost", 6379);
                    String token = tokenGenerator.generate(username, password);
                    jedis.set(username, token);
                    jedis.expire(username, ConstantKit.TOKEN_EXPIRE_TIME);
                    jedis.set(token, username);
                    jedis.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);
                    Long currentTime = System.currentTimeMillis();
                    jedis.set(token + username, currentTime.toString());

                    //用完关闭
                    jedis.close();
                    result.put("status", "登录成功");
                    result.put("token", token);
                    return "success_m";
                }else {result.put("status", "登录失败");
                return null;}
            }
            else {
                //返回到登录页面
                model.addAttribute("data","密码错误");
                return "login_m";
            }

            }
        else{
            //返回到登录页面
            model.addAttribute("data","该用户不存在，请先注册");
            return "login_m";
        }
    }


    //登录界面
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register_m";
    }

    @RequestMapping("/RegisterSuccess")
    @ApiOperation("注册用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String")
    }
    )
    public String toRegisterSuccess(Model model,UserEntity userEntity){
        //将账号密码加入到数据库中
        int add = userLoginServicesl.add(userEntity);
        System.out.println("数据插入成功！");
        model.addAttribute("data","注册成功，请登录！");
        return "login_m";
    }

    //查询所有
    @ApiOperation(value="查询所有用户",notes = "")
    @RequestMapping("/getall")
    public List<UserEntity> queryAreaAll(){
        return userLoginServicesl.queryAll();
    }

    //删除用户
    @RequestMapping("/delete")
    public String Delete(Model model,UserEntity userEntity){
        System.out.println(userEntity.getUsername());
        UserEntity entity = userLoginServicesl.deleteByName(userEntity.getUsername());
        System.out.println("delete successfully");
        model.addAttribute("data","delete successfully！");
        return "login_m";
    }

    @RequestMapping("/findAll")
    public String FindAll(Model model,UserEntity userEntity){
        List<UserEntity> list = userLoginServicesl.queryAll();
        model.addAttribute("list", list);
        return "findAll";
    }

    @ApiOperation("测试token接口")
    @RequestMapping(value = "test", method = RequestMethod.GET)
    @AuthToken
    public ResponseTemplate test() {
        List<UserEntity> user = userLoginServicesl.queryAll();
        return ResponseTemplate.builder()
                .code(200)
                .message("Success")
                .data(user)
                .build();
    }
}
