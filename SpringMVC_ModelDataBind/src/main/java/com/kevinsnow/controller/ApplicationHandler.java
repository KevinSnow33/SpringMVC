package com.kevinsnow.controller;

import com.kevinsnow.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ApplicationHandler {
    //利用request拿到ServletContext(Application对象)
    @RequestMapping("/application")
    public String application(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        User user = new User();
        user.setId(1);
        user.setName("张三");
        application.setAttribute("user",user);
        return "view";
    }
}
