package com.ht.controller;

/**
 * Created by Administrator on 2019/11/12.
 */

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 4、自定义控制器
 */
public class HelloController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception {
        String uname = request.getParameter("uname");
        System.out.println("姓名  "+uname);

        //模型视图 (1、封装要传递到页面的属性，2、设置要跳转的页面的逻辑名称)
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","你好，"+uname);//设置属性
        mv.setViewName("hello");//设置视图的逻辑名称
        System.out.println("mv = " + mv);

        return mv;
    }






}
