package com.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2019/11/19.
 */
@Controller   //表示这是一个控制器
@RequestMapping("/user") //类的访问路径
public class UserController {
    /**
     * 1/(类定义的@RequestMapping注解是可以省略的)
     * 2///方法的请求映射是不能省略的
     * 3/同一个类中 不能有同名的请求映射
     * 4/请求映射名称和方法名称可以不一样
     *
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login1(){
        System.out.println("这是注解版SpringMVC.....");
        return "hello";
    }

}
