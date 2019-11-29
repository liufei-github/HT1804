package com.ht.controller;

import com.ht.bean.User;
import com.ht.dao.EmpDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/11/20.
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Resource  // 自动装配
    private EmpDao empdao;
    @RequestMapping("/list")
    public String list(Map map){
        System.out.println("list.....");
         empdao.emplist();
         List list =null;
         map.put("list",list);
        return "emplist";
    }

    @RequestMapping("/add")
    public String add(User user){
        empdao.add(user);
        return "redirect:list";//redirect重定向 /forward (当要跳转到其他方法或页面时)
    }
}
