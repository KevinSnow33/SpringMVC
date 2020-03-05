package com.kevinsnow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadHandler {


/**
 * 1.使用Apache fileupload组件时，在springmvc.xml和web.xml中都要进行相应配置
 * 2.每次tomcat重启都需要在C:\apache-tomcat-9.0.30\webapps\ROOT 中手动建立file文件夹
 *   否则若file文件夹不存在导致后台报错（浏览器看不到）
 */


//    1.上传单个文件：
    @PostMapping("/upload")
    //以上传图片为例，拿到MultipartFile文件对象后，上传到指定服务器文件夹，并把传回Jsp中显示出来
    public String upload(MultipartFile img, HttpServletRequest request){
        if(img.getSize() > 0){
            //获取用来保存所上传文件的file文件夹的真实路径（通过servletcontext）
            String path = request.getServletContext().getRealPath("file");
            System.out.println(path); //C:\apache-tomcat-9.0.30\webapps\ROOT\file
            //获取所上传文件的文件名
            String name = img.getOriginalFilename();
            //在file文件夹里建立imgFile文件
            File imgFile = new File(path,name);
            try {
                //将所上传的MultipartFile文件对象转换（拷贝）到file文件中
                img.transferTo(imgFile);
                //C:\apache-tomcat-9.0.30\webapps\ROOT\file里可以找到所上传的文件

                //把所上传的文件路径加文件名存入request，以便于在jsp中拿到图片（<img src="图片路径">）
                request.setAttribute("path","/file/"+name);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }return "upload";
    }


//    2.上传多个文件：
    @PostMapping("/uploads")
    public String uploads(MultipartFile[] imgs,HttpServletRequest request){

        String path = request.getServletContext().getRealPath("file");
        String name;

        List<String> paths = new ArrayList<>();

        for (MultipartFile img : imgs) {
            name = img.getOriginalFilename();
            File imgfile = new File(path, name);
            try {
                img.transferTo(imgfile);
                //把路径先加到集合中
                paths.add("/file/"+name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //最后再把集合一次传过去
        request.setAttribute("paths",paths);
        return "uploads";
    }
}
