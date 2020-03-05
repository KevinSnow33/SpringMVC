package com.kevinsnow.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RequestMapping("/handler")  //加一层路径映射
public class HelloHandler {

    //   传统类型url（http://localhost:8080/hello/conventionalURL?name=Zhangshan&age=10）的注解
    @RequestMapping(value = "/conventionalURL", method = RequestMethod.GET,params = {"name","age=10"})
    //{"name","id=10"}中id可以不赋值，如果赋值的话id=10"则访问时必须写id=10
    //@RequestParam("name") String str,这个配对的过程可以省略，只要形参名"str"改成与参数相同的"name"
    public String conventionalURL(@RequestParam("name") String str, @RequestParam("age") int age){
        System.out.println("执行了conventionalURL...");
        System.out.println(str);
        System.out.println(age);
        return "index";
    }

//    RESTful风格url(http://localhost:8080/hello/restfulURL/Zhangshan/10)的注解
    @RequestMapping("/restfulURL/{name}/{age}")
    public String restfulURL(@PathVariable("name") String str,@PathVariable("age") int age){
        System.out.println("执行了restfulURL...");
        System.out.println(str);
        System.out.println(age);
        return "index";
    }

}
