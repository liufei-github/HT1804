package com.ht.service;

import com.ht.bean.Pager;
import com.ht.bean.Stud;

import java.util.List;

/**
 * Created by Administrator on 2019/11/22.
 */
public interface IStudService {
    public List<Stud> allstud(Pager page);

    public int studrow();

    public void addstud(Stud stud);

    public boolean checkname(String stuname);

    public Stud selstudbyno(int stuno);

    public void updstud(Stud stud);

    public void delstud(int stuno);
}
