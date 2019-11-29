package com.ht.controller;

import com.ht.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2019/11/26.
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    /**
     * 普通路径映射
     * @return
     */
    @RequestMapping(value = {"/test1","/create"})
    public String test1(){
        System.out.println("进来了....");
        return "emplist";
    }

    /**
     * URI模板映射
     */
    @RequestMapping("/test2/{userId}/topics/{topicId}")
    public String test2(@PathVariable("userId")String uid,@PathVariable("topicId")String tid){
        System.out.println(uid+" "+tid);
        return "emplist";
    }

    /**
     * Ant风格路径映射
     */
    //@RequestMapping("/product?") //必须匹配一个字符
    @RequestMapping("/product*") //可以匹配0或多个字符，但不能包含/
    public String test3(){
        System.out.println("ant风格进来了。。。");
        return "emplist";
    }

    @RequestMapping("/users/{userId}/{number}")
    public String test5(){
        System.out.println("test5进来了..");
        return "emplist";
    }

    @RequestMapping("/users/{userId}/create")
    public String test4(){
        System.out.println("test4进来了..");
        return "emplist";
    }

    /**
     * 正则表达式路径映射
     */
    @RequestMapping("/pro/{num1:\\d+}")
    public String test6(@PathVariable("num1")String n1){
        System.out.println(n1);
        return "emplist";
    }


    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        session.setAttribute("user",user);
        return "redirect:/";
    }

}
