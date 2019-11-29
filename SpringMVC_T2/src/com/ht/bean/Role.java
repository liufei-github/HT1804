package com.ht.bean;

/**
 * Created by Administrator on 2019/11/19.
 */
public class Role {
    private Integer rid;
    private String uname;

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", uname='" + uname + '\'' +
                '}';
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
