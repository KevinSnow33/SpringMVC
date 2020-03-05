package com.kevinsnow.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class DownloadHandler {

//    下载文件名指定为“schedule.png”的文件（在jsp中url写法指定），下载前需要先上传该文件

    @GetMapping("/download/{name}")
    public void download(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response){
        if (name != null){
            name += ".png";
            String path = request.getServletContext().getRealPath("file");
            File file = new File(path,name);

            OutputStream outputStream = null;
            if (file.exists()){
//              //固定配置
                response.setContentType("application/forc-download");
                //设定下载后的文件名
                response.setHeader("Content-Disposition","attachment;filename=" + name);
                try {
                    outputStream = response.getOutputStream();
                    outputStream.write(FileUtils.readFileToByteArray(file));  //利用FileUtils工具把文件转换成字节数组
                    outputStream.flush();;
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        //关闭输出流
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
