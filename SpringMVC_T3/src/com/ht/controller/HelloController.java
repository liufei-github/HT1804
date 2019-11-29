package com.ht.controller;

import com.alibaba.fastjson.JSONObject;
import com.ht.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/11/21.
 */
@Controller
@RequestMapping("/hello")
@SessionAttributes("user")
public class HelloController {
    /**
     * 1、SessionAttributes 本身并不能进行赋值，通过其他方法的形参给其赋值
     * 2、如果一个方法的形参没有被传递参数，那么它会从SessionAttributes中获取
     * 3、SessionAttributes中设置的值会在Httpsession中也设置一份一样的属性
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public String login(User user){
        System.out.println(user.toString());
        return "hello";
    }

    @RequestMapping("/info")
    public String info(User user, HttpSession session){
        User u = (User)session.getAttribute("user");
        System.out.println("Httpsession 中的 user = "+user.toString());
        System.out.println("个人信息： "+user.toString());
        return "hello";
    }

    @RequestMapping("/loginout")
    public String loginout(SessionStatus status,HttpSession session){
        status.setComplete();//设置SessionAttributes为完成状态
         //session.invalidate();
         return "hello";
    }

    /**
     * 1、 所有方法都会先进入ModelAttribute修饰的方法，然后再进入目标方法
     * 2、目标方法获取的参数可以在ModelAttribute修饰的方法中获取到
     * 3、ModelAttribute修饰的方法中使用Model传递的属性，在目标方法中可以用ModelMPA获取到
     *
     * 4、ModelAttribute用在方法的形参上，表示从前面的@ModelAttribute注解的方法获取值，而不是从请求参数中获取
     * @param abc
     * @param model
     */
    //@ModelAttribute
    public User modeltest(String abc,ModelMap model){
        System.out.println("ModelAttribute方法中的abc  "+abc);
        System.out.println("ModelAttribute进来了");

        //显示传递用Model
        model.addAttribute("msg",abc);

        model.addAttribute("aaa","1111111");

        User u = new User();
        u.setUname("zhangsan");
        u.setPwd("abc");
        //隐式传递（直接传递）model.put("user",u);
        return u;
    }

    @RequestMapping("/test")
    public String test(String abc,ModelMap model,@ModelAttribute("aaa") String aaa){
        System.out.println("获取ModelAttribute传递的属性 "+model.get("msg"));
        System.out.println("获取隐式传递的USer "+ model.get("user"));
        System.out.println("目标方法进来了..."+abc);

        System.out.println("aaa的值为 "+aaa);
        return "hello";
    }

    @RequestMapping(value="/testCookie")
    public String testCookie(@CookieValue(value="JSESSIONID", defaultValue="") String sessionId, ModelMap map){
        map.put("message",sessionId);
        return "hello";
    }

    @RequestMapping(value = "/response/ContentType", headers = "Accept=application/json")
    public void response2(HttpServletResponse response) throws IOException {
        //①表示响应的内容区数据的媒体类型为json格式，且编码为utf-8(客户端应该以utf-8解码)
        response.setContentType("application/json;charset=utf-8");
        //②写出响应体内容
        String jsonData = "{\"username\":\"ht\", \"password\":\"123\"}";
        response.getWriter().write(jsonData);
    }

    /**
     * 1、fastjson包
//     * 2把fastjson注入到spring容器中
     3、给异步方法添加@ResponseBody注解
//     4在页面上发送Ajax请求（jqeury文件不可用，配置一个静态资源映射）
     * @return
     */


    @RequestMapping("/sel")
    @ResponseBody  //(以JSON格式响应客户端)
    public List sel(){
        System.out.println("ajax请求进来了....");
//       Map map = new HashMap();
//       map.put("msg","aaaaaaa");

        List list = new ArrayList();
        User user = new User();
        user.setUname("aaa");
        user.setPwd("aaa");

        User user1 = new User();
        user1.setUname("bbb");
        user1.setPwd("abbbabbba");
        list.add(user);
        list.add(user1);
       return list;
    }

    @RequestMapping("/forwad")
    public String forward(){
        System.out.println("forwad 进来了 ");
        return "redirect:/index.jsp";//forward 转发
    }


}
