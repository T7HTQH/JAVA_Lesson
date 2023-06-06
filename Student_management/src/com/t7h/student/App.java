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

        Frame f = new Frame("ѧ������ϵͳ");
        f.setBounds(100, 100, 640, 320);
        //Menu�޷�ֱ����ӵ������У�ֻ��ֱ����ӵ��˵�������
        JMenu jm = new JMenu("�˵�");
        JMenuBar jmb = new JMenuBar();
        jmb.add(jm);
        JMenuItem item1 = new JMenuItem("���ѧ��");
        JMenuItem item2 = new JMenuItem("��ѯĳ��ѧ��");
        JMenuItem item3 = new JMenuItem("��ѯ����ѧ��");
        JMenuItem item4 = new JMenuItem("�޸�ѧ��");
        JMenuItem item5 = new JMenuItem("ɾ��ѧ��");
        jm.add(item1);
        jm.add(item2);
        jm.add(item3);
        jm.add(item4);
        jm.add(item5);

        ButtonGroup jg = new ButtonGroup();
        JCheckBox jc1 = new JCheckBox("��");
        JCheckBox jc2 = new JCheckBox("Ů");
        jg.add(jc1);
        jg.add(jc2);

        JPanel jp = new JPanel();
        jp.setBackground(Color.white);
        JButton student_add=new JButton("���");
        JButton student_findbyname=new JButton("����ģ����ѯ");
        JButton student_findbynum=new JButton("ѧ�ž�ȷ��ѯ��ѯ");
        JButton student_find_all=new JButton("��ѯ");
        JButton student_modify = new JButton("�޸�");
        JButton student_delete=new JButton("ɾ��");
        JTextArea jt1 = new JTextArea("����");
        JTextField student_name = new JTextField(10);
        JTextArea jt2 = new JTextArea("ѧ��");
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

        item1.addActionListener(new ActionListener() {//�л������ѧ��ҳ��
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
        item2.addActionListener(new ActionListener() {//�л�����ѯ����ѧ������
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
        item3.addActionListener(new ActionListener() {//�л�����ѯ����ѧ������
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.removeAll();
                jp.add(student_find_all);
                f.validate();
                f.repaint();
            }
        });
        item4.addActionListener(new ActionListener() {//�л����޸�ҳ��
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
        jc1.addActionListener(new ActionListener() {//��ѡ�����
            @Override
            public void actionPerformed(ActionEvent e) {
                temp_sex = "��";
            }
        });
        jc2.addActionListener(new ActionListener() {//Ůѡ�����
            @Override
            public void actionPerformed(ActionEvent e) {
                temp_sex = "Ů";
            }
        });
        student_add.addActionListener(new ActionListener() {//��Ӱ�ť����
            @Override
            public void actionPerformed(ActionEvent e) {
                date.setName(student_name.getText());
                date.setNumber(student_id.getText());
                date.setSex(temp_sex);
                if(sql.add(date))
                {

                    System.out.println(student_name.getText());
                    JOptionPane.showMessageDialog(null, "��ӳɹ�");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "��Ϣ����������ѧ���Ѵ���", "Title",JOptionPane.ERROR_MESSAGE);

                }
                System.out.println("0");
            }
        });
        student_findbyname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sql.getByname(student_name.getText())==null){
                    JOptionPane.showMessageDialog(null, "δ�ҵ�ѧ��", "Title",JOptionPane.ERROR_MESSAGE);
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
                            return students.size();     // ����Ϊ���ϴ�С
                        }
                        @Override
                        public int getColumnCount() {
                            return columnNames.length;  // ����
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
        student_findbynum.addActionListener(new ActionListener() {//ͨ��ѧ�Ų��Ұ�ť����
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sql.getBynum(student_id.getText())==null){
                    JOptionPane.showMessageDialog(null, "δ�ҵ�ѧ��", "Title",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    date s = sql.getBynum(student_id.getText());
                    JOptionPane.showMessageDialog(null, "����:"+s.getName()+"\n"+"ѧ��:"+s.getNumber()+"\n"+"�Ա�:"+s.getSex());
                }
            }
        });
        student_find_all.addActionListener(new ActionListener() {//��ѯ����ѧ����ť����
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
                        return students.size();     // ����Ϊ���ϴ�С
                    }
                    @Override
                    public int getColumnCount() {
                        return columnNames.length;  // ����
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
                    JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "��Ϣ����������ѧ�Ų�����", "Title",JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        student_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.setNumber(student_id.getText());
                if(sql.deleteBynumber(student_id.getText()))
                {
                    JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "��ѧ�Ų�����", "Title",JOptionPane.ERROR_MESSAGE);
                }

            }
        });



    }

    public static void main(String[] args) throws SQLException {
        MenuDemo();
    }

}
