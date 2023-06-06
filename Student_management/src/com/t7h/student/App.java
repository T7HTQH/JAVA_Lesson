package com.t7h.student;

import com.t7h.Test09.Test09;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class App {
    private static int index=0;
    static String temp_sex ;
    public static void MenuDemo() throws SQLException {
        webSql sql = new webSql();
        date date = new date();

        Frame f = new Frame("学生管理系统");
        f.setBounds(100, 100, 640, 320);
        //Menu无法直接添加到容器中，只能直接添加到菜单容器中
        JMenu jm = new JMenu("菜单");
        JMenuBar jmb = new JMenuBar();
        jmb.add(jm);
        JMenuItem item1 = new JMenuItem("添加学生");
        JMenuItem item2 = new JMenuItem("查询某个学生");
        JMenuItem item3 = new JMenuItem("查询所有学生");
        JMenuItem item4 = new JMenuItem("修改学生");
        JMenuItem item5 = new JMenuItem("删除学生");
        jm.add(item1);
        jm.add(item2);
        jm.add(item3);
        jm.add(item4);
        jm.add(item5);

        ButtonGroup jg = new ButtonGroup();
        JCheckBox jc1 = new JCheckBox("男");
        JCheckBox jc2 = new JCheckBox("女");
        jg.add(jc1);
        jg.add(jc2);

        JPanel jp = new JPanel();
        jp.setBackground(Color.white);
        JButton student_add=new JButton("添加");
        JButton student_findbyname=new JButton("姓名模糊查询");
        JButton student_findbynum=new JButton("学号精确查询查询");
        JButton student_find_all=new JButton("查询");
        JButton student_modify = new JButton("修改");
        JButton student_delete=new JButton("删除");
        JTextArea jt1 = new JTextArea("姓名");
        JTextField student_name = new JTextField(10);
        JTextArea jt2 = new JTextArea("学号");
        JTextField student_id = new JTextField(10);
        jp.add(jt1);
        jp.add(student_name);
        jp.add(jt2);
        jp.add(student_id);
        jp.add(jc1);
        jp.add(jc2);
        jp.add(student_add);

        f.add(jmb,BorderLayout.NORTH);
        f.add(jp,BorderLayout.CENTER);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

        item1.addActionListener(new ActionListener() {//切换至添加学生页面
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.removeAll();
                jp.add(jt1);
                jp.add(student_name);
                jp.add(jt2);
                jp.add(student_id);
                jp.add(jc1);
                jp.add(jc2);
                jp.add(student_add);
                f.validate();
                f.repaint();
            }
        });
        item2.addActionListener(new ActionListener() {//切换至查询单个学生界面
            @Override
            public void actionPerformed(ActionEvent e) {
                f.removeAll();
                jp.removeAll();
                jp.add(jt1);
                jp.add(student_name);
                jp.add(jt2);
                jp.add(student_id);
                jp.add(jc1);
                jp.add(jc2);
                jp.add(student_findbyname);
                jp.add(student_findbynum);
                f.add(jmb,BorderLayout.NORTH);
                f.add(jp,BorderLayout.CENTER);
                f.validate();
                f.repaint();
            }
        });
        item3.addActionListener(new ActionListener() {//切换至查询所有学生界面
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.removeAll();
                jp.add(student_find_all);
                f.validate();
                f.repaint();
            }
        });
        item4.addActionListener(new ActionListener() {//切换至修改页面
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.removeAll();
                jp.add(jt1);
                jp.add(student_name);
                jp.add(jt2);
                jp.add(student_id);
                jp.add(jc1);
                jp.add(jc2);
                jp.add(student_modify);
                f.validate();
                f.repaint();
            }
        });
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.removeAll();
                jp.add(jt2);
                jp.add(student_id);
                jp.add(student_delete);
                f.validate();
                f.repaint();
            }
        });
        jc1.addActionListener(new ActionListener() {//男选项监听
            @Override
            public void actionPerformed(ActionEvent e) {
                temp_sex = "男";
            }
        });
        jc2.addActionListener(new ActionListener() {//女选项监听
            @Override
            public void actionPerformed(ActionEvent e) {
                temp_sex = "女";
            }
        });
        student_add.addActionListener(new ActionListener() {//添加按钮监听
            @Override
            public void actionPerformed(ActionEvent e) {
                date.setName(student_name.getText());
                date.setNumber(student_id.getText());
                date.setSex(temp_sex);
                if(sql.add(date))
                {

                    System.out.println(student_name.getText());
                    JOptionPane.showMessageDialog(null, "添加成功");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "信息输入有误或该学生已存在", "Title",JOptionPane.ERROR_MESSAGE);

                }
                System.out.println("0");
            }
        });
        student_findbyname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sql.getByname(student_name.getText())==null){
                    JOptionPane.showMessageDialog(null, "未找到学生", "Title",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    List<date> students = sql.getByname(student_name.getText());
                    for (date s : students) {
                        System.out.println(s.getName() + "," + s.getNumber());
                    }
                    String[] columnNames = {"Name", "number","sex"};
                    AbstractTableModel tableModel = new AbstractTableModel() {
                        @Override
                        public int getRowCount() {
                            return students.size();     // 行数为集合大小
                        }
                        @Override
                        public int getColumnCount() {
                            return columnNames.length;  // 列数
                        }
                        @Override
                        public Object getValueAt(int rowIndex, int columnIndex) {
                            date user = students.get(rowIndex);
                            if (columnIndex == 0) return user.getName();
                            if (columnIndex == 1) return user.getNumber();
                            if (columnIndex == 2) return user.getSex();
                            return null;
                        }
                    };
                    JTable table = new JTable(tableModel);

                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setPreferredSize(new Dimension(200,200));
                    jp.removeAll();
                    jp.add(jt1);
                    jp.add(student_name);
                    jp.add(jt2);
                    jp.add(student_id);
                    jp.add(jc1);
                    jp.add(jc2);
                    jp.add(student_findbyname);
                    jp.add(student_findbynum);
                    jp.add(scrollPane);
                    f.validate();
                    f.repaint();
                    tableModel.fireTableDataChanged();
                }
            }
        });
        student_findbynum.addActionListener(new ActionListener() {//通过学号查找按钮监听
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sql.getBynum(student_id.getText())==null){
                    JOptionPane.showMessageDialog(null, "未找到学生", "Title",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    date s = sql.getBynum(student_id.getText());
                    JOptionPane.showMessageDialog(null, "姓名:"+s.getName()+"\n"+"学号:"+s.getNumber()+"\n"+"性别:"+s.getSex());
                }
            }
        });
        student_find_all.addActionListener(new ActionListener() {//查询所有学生按钮监听
            @Override
            public void actionPerformed(ActionEvent e) {
                List<date> students = sql.getAll();
                for (date s : students) {
                    System.out.println(s.getName() + "," + s.getNumber());
                }

                String[] columnNames = {"Name", "number","sex"};
                AbstractTableModel tableModel = new AbstractTableModel() {
                    @Override
                    public int getRowCount() {
                        return students.size();     // 行数为集合大小
                    }
                    @Override
                    public int getColumnCount() {
                        return columnNames.length;  // 列数
                    }
                    @Override
                    public Object getValueAt(int rowIndex, int columnIndex) {
                        date user = students.get(rowIndex);
                        if (columnIndex == 0) return user.getName();
                        if (columnIndex == 1) return user.getNumber();
                        if (columnIndex == 2) return user.getSex();
                        return null;
                    }
                };
                JTable table = new JTable(tableModel);

                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setPreferredSize(new Dimension(200,200));
                jp.removeAll();
                jp.add(student_find_all);
                jp.add(scrollPane);
                f.validate();
                f.repaint();
                tableModel.fireTableDataChanged();


            }
        });

        student_modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.setName(student_name.getText());
                date.setNumber(student_id.getText());
                date.setSex(temp_sex);
                if(sql.modify(date))
                {
                    JOptionPane.showMessageDialog(null, "修改成功");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "信息输入有误或该学号不存在", "Title",JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        student_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.setNumber(student_id.getText());
                if(sql.deleteBynumber(student_id.getText()))
                {
                    JOptionPane.showMessageDialog(null, "删除成功");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "该学号不存在", "Title",JOptionPane.ERROR_MESSAGE);
                }

            }
        });



    }

    public static void main(String[] args) throws SQLException {
        MenuDemo();
    }

}
