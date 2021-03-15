//package com.sjc.login_boot.service;
//
//import com.sjc.login_boot.dao.UserDao;
//import com.sjc.login_boot.entity.UserEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;


//@Service
//public class LoginService {
//    @Autowired
//    private UserDao userDao;
//
//    public String Find(String username,String password){
//        UserEntity User = userDao.findByUsernameAndPassword(username,password);
//        if(User==null){
//            System.out.println("user null");
//            return null;
//        }
//        String bName = User.getUsername();
//        String bPassword= User.getPassword();
//        System.out.println("======"+bName+" "+bPassword);
//
//        if(bName.equals(username)&&bPassword.equals(password)){
//            return "success";
//        }else{
//            return "error";
//        }
//    }
//
//
//}
