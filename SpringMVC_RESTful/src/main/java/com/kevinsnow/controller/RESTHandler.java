package com.kevinsnow.controller;

import com.kevinsnow.entity.User;
import com.kevinsnow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
public class RESTHandler {
//  用@GetMapping，@PostMapping，@PutMapping，@DeleteMapping
//  四个注解代替@RequestMapping



    @Autowired
    private UserRepository userRepository;

//    1.GET:
    //@RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @GetMapping("/findAll")   //http://localhost:8080/findAll
    //直接用@GetMapping代替上面的@RequestMapping
    public String findAll(HttpServletResponse httpServletResponse){
        //处理返回乱码问题
        httpServletResponse.setContentType("text/json;charset=UTF-8");
        return userRepository.findAll().toString();
    }

    @GetMapping("/findById/{id}")  //http://localhost:8080/findById/1
    //RESTful风格url
    public String findById(@PathVariable("id") long id,HttpServletResponse httpServletResponse){
        //处理返回乱码问题
        httpServletResponse.setContentType("text/json;charset=UTF-8");
        return userRepository.findById(id).toString();
    }


//    2,3,4需要用POSTMAN工具测试

//    2.POST：
    @PostMapping("/add")
    public void add(User user){
        userRepository.addOrUpdate(user);
    }


//    3.PUT:
    @PutMapping("/update")
    public void update(User user){
        userRepository.addOrUpdate(user);
    }


//    4.Delete:
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
    }
}
