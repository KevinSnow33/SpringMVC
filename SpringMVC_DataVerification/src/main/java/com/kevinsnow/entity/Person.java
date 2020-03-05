package com.kevinsnow.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Person {

    //    校验规则详解：
//    @Null					被注解的元素必须为null
//    @NotNull				  被注解的元素不能为null
//    @Min(value)			     被注解的元素必须是一个数字，其值必须大于等于指定的最小值
//    @Max(value)			    被注解的元素必须是一个数字，其值必须小于于等于指定的最大值
//    @Email				     被注解的元素必须是电子邮箱地址
//    @Pattern				  被注解的元素必须符合对应的正则表达式
//    @Length				   被注解的元素的大小必须在指定的范围内
//    @NotEmpty			      被注解的字符串的值必须非空
//    Null 和 Empty 是不同的结果，String str = null，str 是 null，String str = ""，str 不是 null，其值为空。


    @NotEmpty(message = "用户名不能为空")
    private String username;
    @Size(min = 6,max = 12,message = "密码6-12位")
    private String password;
    @Email(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\\\.[a-zA-Z0-9-]+)*\\\\.[a-zA-Z0-9]{2,6}$",message = "请输入正确的邮箱格式")
    private String email;
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\\\\\d{8}$",message = "请输入正确的电话")
    private String phone;
}
