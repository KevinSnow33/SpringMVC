package com.kevinsnow.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//还需要在springmvc.xml文件中配置转换器
//类的定义处泛型<String,Date>写明要转换的类型
public class DateConverter implements Converter<String,Date> {

    private String datePattern;

    public DateConverter(String datePattern){
        //构造函数中接受日期格式的字符串
        this.datePattern = datePattern;
    }

    //JSP中input标签的name的值：必须是模型对象Date的类名的第一个字母变小写：date
    @Override
    public Date convert(String s) {
        //设定格式化日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        Date date = null;

        try {
            //把字符串的时间转为date对象
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //返回date
        return date;
    }
}
