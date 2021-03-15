//package com.sjc.login_boot.controller;
//
//import com.sjc.login_boot.service.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/LLL")
//public class LoginController {
//    @Autowired
//    private LoginService loginService;
//
//    @RequestMapping("/user")
//    public String getLogin(@RequestParam("name")String name,
//                           @RequestParam("password")String password)
//    {
//        String s;
//        s=loginService.Find(name,password);
//        System.out.println(name);
//        System.out.println(password);
//        System.out.println(s);
//        if(s!=null&&s.equals("success")){
//            System.out.println("login success");
//            return "wel";
//        }else {
//            System.out.println("login again");
//            return "login";
//        }
//
//
//    }
//}
