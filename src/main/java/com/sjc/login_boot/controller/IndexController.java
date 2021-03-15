//package com.sjc.login_boot.controller;
//
//import com.sjc.login_boot.dao.UserDao;
//import com.sjc.login_boot.entity.UserEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//@RequestMapping("/front/*")
//public class IndexController {
//    @Autowired
//    private UserDao userDao;
//
////    @RequestMapping("/index")
////    public  String index(){
////        return "index";
////    }
//
//    @RequestMapping("/register")
//    public String register(){
//        return "register";
//    }
//
//    @RequestMapping("/wel")
//    public String wel(){
//        return "wel";
//    }
//    //登录
//    @RequestMapping("/login")
//    public String login(){
//        return "login";
//    }
//    //注册方法
//    @RequestMapping("/addregister")
//    public String register(HttpServletRequest request){
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String password2 = request.getParameter("password2");
//        if (password.equals(password2)){
//            UserEntity userEntity = new UserEntity();
//            userEntity.setUsername(username);
//            userEntity.setPassword(password);
//            userDao.save(userEntity);
//            return "login";
//        }else {
//            return "register";
//        }
//    }
//
//    }
