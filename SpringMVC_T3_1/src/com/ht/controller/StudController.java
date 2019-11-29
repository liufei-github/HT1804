package com.ht.controller;

import com.ht.bean.Pager;
import com.ht.bean.Stud;
import com.ht.service.IStudService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/11/22.
 */
@Controller
@RequestMapping("/stud")
public class StudController {

    @Resource //自动装配 注入到Spring容器的bean
    private IStudService is;

    @RequestMapping("/list")
    public String list(Pager p, Map model) {

        p.setTotalRow(is.studrow());//总行数

        // (总行数+每页行数-1)/每页行数//  10+5-1   / 5
        p.setTotalPage((p.getTotalRow() + p.getPageSize() - 1) / p.getPageSize());//计算总页数

        if (p.getCurrPage() < 1) {
            p.setCurrPage(1);
        }
        if (p.getCurrPage() > p.getTotalPage()) {
            p.setCurrPage(p.getTotalPage());
        }

        List list = is.allstud(p);

        //设置数据
        p.setDatas(list);

        //把对象设置到页面
        model.put("p", p);
        return "studlist";
    }

    @RequestMapping("/toadd")
    public String toadd() {
        return "studadd";
    }

    @RequestMapping("/add")
    public String add(Stud stud) {
        is.addstud(stud);
        return "redirect:list";
    }

    @RequestMapping("/checkname")
    @ResponseBody
    public boolean checkname(String stuname) {
        System.out.println("姓名检查：" + stuname);
        boolean bln = is.checkname(stuname);
        return bln;
    }

    @RequestMapping("/toupd")
    public String toupd(int stuno, Map map) {
        Stud stud = is.selstudbyno(stuno);
        map.put("stud", stud);
        return "studupd";
    }

    @RequestMapping("/upd")
    public String upd(Stud stud){
        is.updstud(stud);
        return "redirect:list";
    }

    @RequestMapping("/del")
    public String del(int stuno){
        is.delstud(stuno);
        return "redirect:list";
    }
}
