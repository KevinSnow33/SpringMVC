package com.kevinsnow.controller;

import com.kevinsnow.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Handler {

    @GetMapping("/tagTest")
    public ModelAndView tagTest(){
        ModelAndView modelAndView = new ModelAndView("tagTest");
        User user = new User("张三",1L);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @GetMapping("/allTags")
    public ModelAndView allTags(){
        ModelAndView modelAndView = new ModelAndView("allTags");
        User user = new User("张三",1L);

        user.setPassword("I'm password");

        user.setCheckboxFlag(true);

        user.setSelectedHobbys(Arrays.asList("读书","看电影","玩游戏"));   //打勾的小集合
        user.setAllHobbys(Arrays.asList("摄影","读书","听音乐","看电影","旅游","玩游戏")); //大集合

        user.setGrade(1);
        Map<Integer,String> gradeMap = new HashMap<>();
        gradeMap.put(1,"一年级");
        gradeMap.put(2,"二年级");
        gradeMap.put(3,"三年级");
        gradeMap.put(4,"四年级");
        gradeMap.put(5,"五年级");
        gradeMap.put(6,"六年级");
        user.setGradeMap(gradeMap);

        int[] citys = {1,2,3,4};
        user.setCity(citys);
        Map<Integer,String> cityMap = new HashMap<>();
        cityMap.put(1,"北京");
        cityMap.put(2,"上海");
        cityMap.put(3,"广州");
        cityMap.put(4,"深圳");
        user.setCityMap(cityMap);

        user.setTextareaDefault("I'm default content of Textarea");

        modelAndView.addObject("user",user);
        return modelAndView;
    }
}
