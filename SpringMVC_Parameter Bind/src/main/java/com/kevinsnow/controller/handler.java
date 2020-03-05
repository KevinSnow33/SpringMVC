package com.kevinsnow.controller;

import com.kevinsnow.entity.User;
import com.kevinsnow.entity.Userlist;
import com.kevinsnow.entity.Usermap;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RestController //表示该控制器会直接将业务方法的返回值响应给客户端，不进行视图解析。
@Controller
//此处没写@RequestMapping省略了中间路径，如果上面是@Component而非@Controller的话必须写中间路径
public class handler {

//   一.基本类型：
    @RequestMapping("/baseType")
//    @ResponseBody
//    //@ResponseBody 表示 Spring MVC 会直接将业务方法的返回值响应给客户端，如果不加,Spring MVC 会将业务方法的放回值
//    // 传递给 DispatcherServlet，再由DisptacherServlet调用 ViewResolver对返回值进行解析，映射到一个 JSP 资源。
//    //或者在给类加@RestController注解
    public String baseType(int id){
        //基本类型转String三种方式：
        //1.
        //  return id + "";
        //2.
        //  return String.valueOf(id);
        //3.
        Integer id1 = id;
        return id1.toString();
    }

//    二.包装类型：
    @RequestMapping("/packageType")
    //形参中@RequestParam进行参数绑定，required字段为true则请求要求必须传该参数num，defaultValue
    //是设置在请求中没传num参数时，num参数的默认值
    public String packageType(@RequestParam(value = "num",required = false,defaultValue = "2") Integer id){
        return String.valueOf(id);
    }

//    三.数组：
    @RequestMapping("/array")
    //当参数name按name=zhangsan&name=lisi设置多个时，在形参里用数组接受
    //http://localhost:8080/array?name=zhangsan&name=lisi
    public String array(@RequestParam("name") String []names){
//        String str = names.toString();
        String str = Arrays.toString(names);
        return str;
        //返回浏览器显示结果：[zhangsan, lisi]
    }

//    四.List集合：(JSP中name的写法详见listsubmit)
    //Spring MVC不支持Lis类型的直接转换，需要把List集合包装成一个类中的对象（Userlist类中的users），再进行赋值提交
    @RequestMapping("/list")
    public String list(Userlist userlist){
        StringBuilder stringBuilder = new StringBuilder();
        for (User user:userlist.getUsers()){
            //userlist.getUsers()是取得userlist对象中user属性的方法（通过lombok自动生成的getter）
            stringBuilder.append(user);
            //toString方法也自动被lombok重写，所以直接append（对象名）即可
        }

        //处理@ResponseBody返回的中⽂乱码，在springmvc.xml中配置消息转换器，详见springmvc.xml
        return stringBuilder.toString();
        //返回浏览器显示结果：User(name=大鼠, id=1)User(name=小鼠, id=2)User(name=耗耗, id=3)
    }

//    五.Map集合： (JSP中name的写法详见mapsubmit)
    @RequestMapping("/map")
    public String map(Usermap usermap){
        Set<String> keys = usermap.getMap().keySet();  //取得map双列集合中的key集合
        StringBuilder stringBuilder = new StringBuilder();
        for (String key:keys){    //遍历key集合
            stringBuilder.append(usermap.getMap().get(key));  //通过key拿到value
        }
        return stringBuilder.toString();
        //返回浏览器显示结果：User(name=AA, id=1)User(name=BB, id=2)User(name=CC, id=3)
    }

//    六.JSON对象
    //Spring MVC 中的 JSON 和 JavaBean 的转换需要借助于fastjson，
    //在pom.xml 引入相关依赖，并在springmvc.xml添加fastjson配置

    @RequestMapping("/json")
    public User json(@RequestBody User user){
        //接受JSON对象必须加 @RequestBody 注解，与@ResponseBody完全不同，
        // 是指在请求中获得一个JSON对象，并赋给user
        System.out.println(user);
        user.setId(6);
        user.setName("张六");
        return user;
    }

}
