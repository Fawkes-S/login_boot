package com.sjc.login_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LoginBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginBootApplication.class, args);
    }

}
