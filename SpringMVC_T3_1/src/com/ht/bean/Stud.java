package com.ht.bean;

/**
 * Created by Administrator on 2019/11/22.
 */
public class Stud {
    private int stuno;
    private String stuname;
    private String birth;
    private float hight;
    private int classno;
    private String sex;

    @Override
    public String toString() {
        return "Stud{" +
                "stuno=" + stuno +
                ", stuname='" + stuname + '\'' +
                ", birth='" + birth + '\'' +
                ", hight=" + hight +
                ", classno=" + classno +
                ", sex='" + sex + '\'' +
                '}';
    }

    public int getStuno() {
        return stuno;
    }

    public void setStuno(int stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public float getHight() {
        return hight;
    }

    public void setHight(float hight) {
        this.hight = hight;
    }

    public int getClassno() {
        return classno;
    }

    public void setClassno(int classno) {
        this.classno = classno;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
