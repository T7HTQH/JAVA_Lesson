package com.t7h.Test09;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test09 {
    public static class Student {
        private int id;
        private String sno;
        private String sname;

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public String getsno() {
            return sno;
        }
        public void setsno(String sno) {
            this.sno = sno;
        }

        public String getsname() {
            return sname;
        }
        public void setsname(String sname) {
            this.sname = sname;
        }
    }
    public static class DBUtil {
        private static String driver = "com.mysql.jdbc.cj.Driver";
        private static String url = "jdbc:mysql://localhost:3306/mxdb ?serverTimezone=UTC";
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
    }
    public static class StudentDao {
        //连接数据库的Connection对象
        private Connection conn;

        public StudentDao() throws SQLException {
            conn = DBUtil.getConnection();
        }

        //添加学生
        public boolean add(Student student) {
            String sql = "insert into student(sno, sname) values(?, ?)";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, student.getsno());
                stmt.setString(2, student.getsname());
                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        //查询所有学生
        public List<Student> getAll() {
            String sql = "select * from student";
            List<Student> students = new ArrayList<>();
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setsno(rs.getString("sno"));
                    student.setsname(rs.getString("sname"));
                    students.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return students;
        }

        //根据学号查找学生
        public Student getBysno(String sno) {
            String sql = "select * from student where sno = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, sno);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setsno(rs.getString("sno"));
                    student.setsname(rs.getString("sname"));
                    return student;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        //根据姓名查找学生(模糊匹配)
        public List<Student> getBysname(String sname) {
            String sql = "select * from student where sname like ?";
            List<Student> students = new ArrayList<>();
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, "%" + sname + "%");
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setsno(rs.getString("sno"));
                    student.setsname(rs.getString("sname"));
                    students.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return students;
        }

        //根据学号删除学生
        public boolean deleteBysno(String sno) {
            String sql = "delete from student where sno = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, sno);
                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        //修改学生
        public boolean modify(Student student) {
            String sql = "update student set sname=? where sno=?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, student.getsname());
                stmt.setString(2, student.getsno());
                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
    public static void main(String[] args) throws SQLException {
        //创建StudentDao对象
        StudentDao dao = new StudentDao();

        //添加学生
        Student student = new Student();
        student.setsno("1001");
        student.setsname("bbb");
        dao.add(student);
        student.setsno("1002");
        student.setsname("ccc");
        dao.add(student);
        student.setsno("1003");
        student.setsname("ddd");
        dao.add(student);
        student.setsno("1004");
        student.setsname("eee");
        dao.add(student);

        //查询所有学生
        List<Student> students = dao.getAll();
        System.out.println("所有学生:");
        for (Student s : students) {
            System.out.println(s.getsno() + "," + s.getsname());
        }

        //根据学号查询学生
        Student s1 = dao.getBysno("1004");
        System.out.println("学号查找结果:"+s1.getsno() + "," + s1.getsname());

        //根据姓名模糊查询学生
        List<Student> students2 = dao.getBysname("aaa");
        for (Student s : students2) {
            System.out.println("模糊查找结果"+s.getsno() + "," + s.getsname());
        }

        //删除学生
        //ao.deleteBysno("1001");

        //修改学生
        student.setsname("ggg");
        student.setsno("1003");
        dao.modify(student);

        //再查询所有学生
        students = dao.getAll();
        System.out.println("第二次查询:");
        for (Student s : students) {
            System.out.println(s.getsno() + "," + s.getsname());
        }
    }
}
