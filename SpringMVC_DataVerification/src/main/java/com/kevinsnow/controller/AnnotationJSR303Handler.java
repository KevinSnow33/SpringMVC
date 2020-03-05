package com.kevinsnow.controller;

import com.kevinsnow.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AnnotationJSR303Handler {
//需要先在springmvc.xml配置验证器（ValidatorAnnotation和AnnotationJSR303Annotation的annotation-driven都需要单独配，不能共存）

//1.绑定数据（在浏览器用get访问）
    //先在浏览器用get请求访问“/login”，将模型数据返回到jsp（否则modelAttribute是空的）
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("person",new Person());
        return "register";
    }

//2.提供验证（用表单提交时的post访问）
    @PostMapping("/register")
    //JSR303中用的注解是：@Valid
    public String register(@Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }
        return "index";
    }
}
