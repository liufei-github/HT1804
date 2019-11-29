package com.ht.service.impl;

import com.ht.bean.Pager;
import com.ht.bean.Stud;
import com.ht.common.DBConnection;
import com.ht.service.IStudService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/11/22.
 */
@Service
public class StudServiceImpl implements IStudService {
    @Override
    public List<Stud> allstud(Pager p) {
        List list = new ArrayList();
        Connection conn = DBConnection.getConnection();
        String sql="select * from (select e.*,rownum r from stud e where rownum<="+(p.getPageSize()*p.getCurrPage())+") where r>"+(p.getCurrPage()-1)*p.getPageSize();
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            while(rs.next()){
                Stud stud = new Stud();
                stud.setStuno(rs.getInt("stuno"));
                stud.setStuname(rs.getString("stuname"));
                stud.setBirth(rs.getString("birth"));
                stud.setClassno(rs.getInt("classno"));
                stud.setSex(rs.getString("sex"));
                stud.setHight(rs.getFloat("hight"));
                list.add(stud);
            }
            rs.close();
            prst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int studrow() {
        Connection conn = DBConnection.getConnection();
        String sql="select count(*) from stud";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst .executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void addstud(Stud stud) {
        Connection conn = DBConnection.getConnection();
        String sql="insert into stud values(seq_stud.nextval,?,to_date(?,'yyyy-MM-dd'),?,?,?)";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1,stud.getStuname());
            prst.setString(2,stud.getBirth());
            prst.setFloat(3,stud.getHight());
            prst.setInt(4,stud.getClassno());
            prst.setString(5,stud.getSex());
            prst.executeUpdate();
            prst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkname(String stuname) {
        Connection conn = DBConnection.getConnection();
        String sql="select * from STUD where stuname='"+stuname+"'";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst .executeQuery();
            if(rs.next()){
                return true; //说明这个姓名存在数据库中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Stud selstudbyno(int stuno) {
        Connection conn = DBConnection.getConnection();
        String sql="select * from stud where stuno="+stuno;
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            while(rs.next()){
                Stud stud = new Stud();
                stud.setStuno(rs.getInt("stuno"));
                stud.setStuname(rs.getString("stuname"));
                stud.setBirth(rs.getString("birth"));
                stud.setClassno(rs.getInt("classno"));
                stud.setSex(rs.getString("sex"));
                stud.setHight(rs.getFloat("hight"));
                return stud;
            }
            rs.close();
            prst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updstud(Stud stud) {
        Connection conn = DBConnection.getConnection();
        String sql="update STUD set stuname=?,birth=to_date(?,'yyyy-MM-dd'),hight=? ,classno=?,sex=? where stuno=?";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1,stud.getStuname());
            prst.setString(2,stud.getBirth());
            prst.setFloat(3,stud.getHight());
            prst.setInt(4,stud.getClassno());
            prst.setString(5,stud.getSex());
            prst.setInt(6,stud.getStuno());
            prst.executeUpdate();
            prst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delstud(int stuno) {
        Connection conn = DBConnection.getConnection();
        String sql="delete from stud  where stuno="+stuno;
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.executeUpdate();
            prst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
