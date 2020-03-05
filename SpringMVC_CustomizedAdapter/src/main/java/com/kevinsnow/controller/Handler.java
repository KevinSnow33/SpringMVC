package com.kevinsnow.controller;

import com.kevinsnow.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController //直接返回数据
public class Handler {
    @RequestMapping("/date")
    public String date(Date date){
        //转换成date时，先进入DateConverter类中的构造函数，
        // 然后进入convert函数进行转换，返回值传到这里的date
        return date.toString();
    }

    @RequestMapping("/user")
    public String user(User user){
        return user.toString();
    }

}
