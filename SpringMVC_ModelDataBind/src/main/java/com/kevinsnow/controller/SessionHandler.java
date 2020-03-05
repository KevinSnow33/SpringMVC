package com.kevinsnow.controller;

import com.kevinsnow.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
//@SessionAttributes(value = "user")  //只要向 [request] 中添加了了 key = "user"的对象时，就把相应模型也加进session
@SessionAttributes(types = User.class)   //只要向[request]中添加了数据类型是 User的对象，就把相应模型也加进session
public class SessionHandler {
//      将模型数据绑定到 session 对象

// 一.原生方式：
    //1.利用request拿到session
    @RequestMapping("/session")
    public String session(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = new User();
        user.setId(1);
        user.setName("张三");
        session.setAttribute("user",user);
        return "view";
    }
    //2.直接拿到session
    @RequestMapping("/session2")
    public String session2(HttpSession session){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        session.setAttribute("user",user);
        return "view";
    }


// 二.利用@SessionAttribute注解:

    //1.@SessionAttributes(value = "user")，只要向 [request] 中添加了了 key = "user"的对象时，就把相应模型也加进session
    //2.@SessionAttributes(types = User.class)   //只要向[request]中添加了数据类型是 User的对象，就把相应模型也加进session
    @RequestMapping("/sessionAttribute")
    public String sessionAttributeTest(Map<String, User> map){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        map.put("user",user);
        return "view";
    }
}
