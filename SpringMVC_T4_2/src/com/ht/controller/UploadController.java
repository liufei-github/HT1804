package com.ht.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2019/11/28.
 */
@Controller
@RequestMapping("/user")
public class UploadController {

    @RequestMapping("/upload")
    public String upload(MultipartFile face, HttpServletRequest request,Model model){
        System.out.println("进来了..");
        //使用UUID得到一个新的随机名字
        String picName = UUID.randomUUID().toString();
        //得到上传原文件的名字
        String oriName = face.getOriginalFilename();
        System.out.println(" 一个名字  "+face.getName());
        //截取文件的扩展名
        String exdName = oriName.substring(oriName.lastIndexOf("."));
        //得到项目根目录
        String path = request.getSession().getServletContext().getRealPath("\\");
        System.out.println("项目根目录 "+path);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String strDate = sf.format(new Date());//得到格式化的年月日 20191128
        //文件夹目录
        String dirName = "upload//"+strDate;
        File dirFile = new File(path+dirName);
        if(!dirFile.exists()){
            dirFile.mkdirs();//多层目录使用mkdirs
        }
        //新文件名 afsdfgfdgf.jpb
        String newFilename = picName+exdName;
        File newFile = new File(path+dirName,newFilename);
        try {
            //将 MultipartFile 转存为 新的文件
            face.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("fileName",dirName+"//"+newFilename);
        System.out.println("传到页面的 名字  "+dirName+"//"+newFilename);
        return "hello";
    }


//    @RequestMapping("/testdate")
//    public void testdate(Date sdate){
//        System.out.println(sdate.toLocaleString());
//    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        //注册自定义的属性编辑器
//        //1、日期
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        dateFormat.setLenient(false);
//        //表示如果命令对象有 Date 类型的属性，将使用该属性编辑器进行类型转换
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//    }


    @RequestMapping("/testdate2")
    public String testdate2(String sdate){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        try {
            Date date = sf.parse(sdate);
            System.out.println(date.toLocaleString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "hello";
    }

    @RequestMapping("/toindex")
    public String toindex(){
        return "index";
    }
}
