package com.kevinsnow.controller;

import com.kevinsnow.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@RequestMapping("/handler")  //加一层路径映射
public class Handler {

//  通过映射可以直接在业务方法中【获取Cookie】的值
    @RequestMapping("/cookie")
    public String cookie(@CookieValue(value = "JSESSIONID") String sessionID){
        //jsessionid就是用来判断当前用户对应于哪个session。
        // 换句话说服务器识别session的方法是通过jsessionid来告诉服务器该客户端的session在内存的什么地方。
        System.out.println(sessionID);
        return "index";
    }


//   根据请求参数名和JavaBean属性名进行【自动匹配】，自动为对象填充属性值，同时支持级联属性
//   过滤器详见web.xml
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    //测试此处时url为：/save.jsp，先在jsp拿到user对象的各个属性，然后转到这里自动将属性封装成user对象
    public String save(User user){
        //user的address属性是对象，address对象的属性是value，在jsp中通过级联的方式把address.value也提交上来，
        // 即可将address对象一起封装进user对象中

        //user的score属性是集合，在jsp中通过name="score[0]"的方式提交参数

        //直接打印的话，中文会乱码，需要在 web.xml 添加 Spring MVC自带的过滤器进行过滤
        System.out.println(user);
        return "index";
    }


// 【转发】：转发是服务器端跳转，是同一次请求在服务器端被转发，客户端的url地址不变
    @RequestMapping("/forward")
    public String forward() {
        return "forward:/index.jsp"; //等于return "index";
    }

//  【重定向】：重定向是客户端跳转，相当于新一次请求，客户端的url地址变化
    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect:/index.jsp";
    }



}
