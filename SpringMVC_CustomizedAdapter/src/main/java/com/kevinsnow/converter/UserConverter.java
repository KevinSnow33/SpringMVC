package com.kevinsnow.converter;

import com.kevinsnow.entity.User;
import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<String, User> {
    //JSP中input标签的name的值：必须是模型对象User的类名的第一个字母变小写：user
    @Override
    public User convert(String s) {
        //请求为"张三-01"，通过s.split("-")把参数分开存入数组
        String[] args = s.split("-");
        User user = new User();
        user.setName(args[0]);
        user.setId(Integer.parseInt(args[1]));
        return user;
    }
}
