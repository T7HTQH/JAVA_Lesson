package com.t7h.student;

import com.t7h.Test09.Test09;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class webSql {
    private static String driver = "com.mysql.jdbc.cj.Driver";
    private static String url = "jdbc:mysql://localhost:3306/mxdb ?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
    private static String usersname = "root";
    private static String password = "2053778260";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usersname, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Connection conn;

    public webSql() throws SQLException {
        conn = getConnection();
    }
    public boolean add(date student) {
        String sql = "insert into student(name, number,sex) values(?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            System.out.println(student.getName());
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getNumber());
            stmt.setString(3, student.getSex());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            //e.printStackTrace();
            //System.out.println("exit");
        }
        return false;
    }
    public List<date> getAll() {
        String sql = "select * from student";
        List<date> students = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                date student = new date();
                student.setName(rs.getString("name"));
                student.setNumber(rs.getString("number"));
                student.setSex(rs.getString("sex"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    public date getBynum(String number) {
        String sql = "select * from student where number = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, number);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                date student = new date();
                student.setName(rs.getString("name"));
                student.setNumber(rs.getString("number"));
                student.setSex(rs.getString("sex"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<date> getByname(String name) {
        String sql = "select * from student where name like ?";
        List<date> students = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                date student = new date();
                student.setName(rs.getString("name"));
                student.setNumber(rs.getString("number"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    public boolean modify(date student) {
        String sql = "update student set name=?, sex=? where number=? ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setString(2,student.getSex());
            stmt.setString(3, student.getNumber());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteBynumber(String number) {
        String sql = "delete from student where number = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, number);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}

