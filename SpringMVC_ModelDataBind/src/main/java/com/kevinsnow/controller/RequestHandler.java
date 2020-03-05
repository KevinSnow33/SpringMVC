package com.kevinsnow.controller;

import com.kevinsnow.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 模型数据的绑定是由 ViewResolver 来完成的，实际开发中，我们需要先添加模型数据，
 * 再交给ViewResolver 来绑定。
 * Spring MVC提供了了以下⼏几种方式添加模型数据：
 *      Map
 *      Model
 *      ModelAndView
 *      @SessionAttribute
 *      @ModelAttribute
 */

@Controller
public class RequestHandler {
//    将模型数据绑定到 request对象的几种方式

//    1.Map
    @RequestMapping("/map")
    //在形参里写好Map<String, User> map
    public String map(Map<String, User> map) {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        map.put("user", user);  //然后把对象放进map，即可自动放入request中
        return "view"; //在view.jsp中通过EL表达式把user展示出来
    }


//    2.Model
    @RequestMapping("/model")
    //在形参里写好Model model
    public String model(Model model) {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        model.addAttribute("user", user); //然后把对象放进model，即可自动放入request中
        return "view";
    }


//    3.ModelAndView
    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        ModelAndView modelAndView = new ModelAndView(); //建立modelAndView对象
        modelAndView.addObject("user", user); //然后把user数据和视图view全添加进去
        modelAndView.setViewName("view");
        return modelAndView;
    }

    @RequestMapping("/modelAndView2")
    public ModelAndView modelAndView2() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        View view = new InternalResourceView("/view.jsp");
        modelAndView.setView(view);
        return modelAndView;
    }

    @RequestMapping("/modelAndView3")
    public ModelAndView modelAndView3() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/modelAndView4")
    public ModelAndView modelAndView4() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/modelAndView5")
    public ModelAndView modelAndView5() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        Map<String, User> map = new HashMap<>();
        map.put("user", user);
        ModelAndView modelAndView = new ModelAndView("view", map);
        return modelAndView;
    }

    @RequestMapping("/modelAndView6")
    public ModelAndView modelAndView6() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        Map<String, User> map = new HashMap<>();
        map.put("user", user);
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view, map);
        return modelAndView;
    }

    @RequestMapping("/modelAndView7")
    public ModelAndView modelAndView7() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        ModelAndView modelAndView = new ModelAndView("view", "user", user);
        return modelAndView;
    }

    @RequestMapping("/modelAndView8")
    public ModelAndView modelAndView8() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view, "user", user);
        return modelAndView;
    }


//    4.HttpServletRequest
    @RequestMapping("/request")
    //利用原生的request。需要在形参处添加HttpServletRequest request
    public String request(HttpServletRequest request) {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        request.setAttribute("user", user);
        return "view";
    }


//    5.@ModelAttribute
    //  定义一个方法，该方法专门用来返回要填充到模型数据中的对象
    //  任何业务方法执行前都要先执行@ModelAttribute注解标明的方法
    @ModelAttribute
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        //return相当于把模型数据绑定到request对象，调用业务方法时模型数据不必再次绑定
        return user;
    }
    //  业务方法中无需再处理模型数据，只需返回视图即可
    @RequestMapping("/modelAttribute")
    public String modelAttribute(){
        //调用业务方法时一定先执行@ModelAttribute注解表明的方法
        return "view";
    }


//    //@ModelAttribute标注的方法也可以采用不return的方式，
//    //即在方法里直接绑定数据模型到request对象中
//    @ModelAttribute
//    public void getUser(Map<String,User> map){
//        User user = new User();
//        user.setId(1);
//        user.setName("张三");
//        map.put("user",user);
//    }
//    @ModelAttribute
//    public void getUser(Model model){
//        User user = new User();
//        user.setId(1);
//        user.setName("张三");
//        model.addAttribute("user",user);
//    }






}