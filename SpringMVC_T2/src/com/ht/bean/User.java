package com.ht.bean;

/**
 * Created by Administrator on 2019/11/19.
 */
public class User {
    private Integer id;
    private String uname;
    private Integer age;
    private Float hight;

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHight() {
        return hight;
    }

    public void setHight(Float hight) {
        this.hight = hight;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                ", hight=" + hight +
                '}';
    }

}
