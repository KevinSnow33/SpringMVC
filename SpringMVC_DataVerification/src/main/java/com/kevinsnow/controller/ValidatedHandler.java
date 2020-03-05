package com.kevinsnow.controller;

import com.kevinsnow.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ValidatedHandler {
//需要先在springmvc.xml配置验证器（ValidatorAnnotation和AnnotationJSR303Annotation的annotation-driven都需要单独配，不能共存）

//1.绑定数据（在浏览器用get访问）
    //先在浏览器用get请求访问“/login”，将模型数据返回到jsp（否则modelAttribute是空的）
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

//2.提供验证（用表单提交时的post访问）
    @PostMapping("/login")
    public String login(@Validated User user, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "login";
        return "index";
    }
}
