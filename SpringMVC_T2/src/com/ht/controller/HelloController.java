package com.ht.controller;

import com.ht.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2019/11/19.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/test1")
    public ModelAndView test1(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("att1","value1");//带到页面的属性
        mv.setViewName("hello"); //跳转的视图逻辑名称
        return mv;
    }

    @RequestMapping("/test2")
    public String test2(Map map, Model model, ModelMap mp){
        map.put("att2","value2");
        model.addAttribute("att3","value3");
        mp.addAttribute("att4","value4");
        return "hello";
    }

    @RequestMapping("/param1")
    public String param1(HttpServletRequest request){
        String str = request.getParameter("str");
        System.out.println("str = "+str);
        return "hello";
    }

    @RequestMapping("/param2")
    public String param2(@RequestParam(value="username",required = true,defaultValue = "lisi")String uname){
        System.out.println("uname = "+uname);
        return "hello";
    }

    /**
     * 根据参数名称去匹配
     * @param id
     * @param uname
     * @param hight
     * @return
     */
    @RequestMapping("/param3")
    public String param3(int id,String uname,float hight){
        System.out.println("id = "+id+"uname = "+uname+" hight="+hight);
        return "hello";
    }

    /**
     * 使用javabean对象来获取参数
     */
    @RequestMapping("/param4")
    public String param4(User user){
        System.out.println(user.toString());
        return "hello";
    }

    /**
     * 附属对象在传递参数时 需要加上对象名.参数名
     * @param user
     * @return
     */
    @RequestMapping("/param6")
    public String param6(User user){
        System.out.println(user.toString());
        System.out.println(user.getRole().toString());
        return "hello";
    }

    /*
    REST风格请求
     */
    @RequestMapping("/param5/{userid}")
    public String param5(@PathVariable("userid") String uid){
        System.out.println(uid);
        return "hello";
    }
}
