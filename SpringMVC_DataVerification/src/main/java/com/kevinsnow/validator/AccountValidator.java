package com.kevinsnow.validator;

import com.kevinsnow.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AccountValidator implements Validator {


    //使用时，需要在springmvc.xml配置验证器
    // 1.添加bean <bean id="accountValidator" class="com.kevinsnow.validator.AccountValidator"></bean>
    // 2.<mvc:annotation-driven validator="accountValidator">

    @Override
    //supports方法先于validate方法执行
    // 用来首先验证数据类型是否支持，支持再进入validate方法
    public boolean supports(Class<?> aClass) {
        //返回值是bool，判断传进来的类是否是User类
        return User.class.equals(aClass); //类名.class为获取运行时类
    }

    @Override
    public void validate(Object o, Errors errors) {
        //4个参数，第一个是传递用大顶errors，第二个是验证的“域”名，第三个是name的错误值，第四个为返回的信息
        ValidationUtils.rejectIfEmpty(errors,"name",null,"姓名不能为空");
        ValidationUtils.rejectIfEmpty(errors,"password",null,"密码不能为空");
    }
}
