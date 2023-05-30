package com.t7h.Test10;

import javax.swing.*;
import java.awt.event.*;

public class Test10 {
    private JFrame frame;
    private JPanel panel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel genderLabel;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JLabel hobbyLabel;
    private JCheckBox readingBox;
    private JCheckBox musicBox;
    private JCheckBox movieBox;
    private JTextArea introArea;
    private JButton submitButton;

    public Test10() {
        frame = new JFrame("用户注册");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        nameLabel = new JLabel("姓名");
        nameLabel.setBounds(30, 30, 60, 30);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 30, 150, 30);
        panel.add(nameField);

        // 添加性别选择框及标签
        genderLabel = new JLabel("性别");
        genderLabel.setBounds(30, 70, 60, 30);
        panel.add(genderLabel);

        maleButton = new JRadioButton("男");
        maleButton.setBounds(100, 70, 60, 30);
        panel.add(maleButton);

        femaleButton = new JRadioButton("女");
        femaleButton.setBounds(170, 70, 60, 30);
        panel.add(femaleButton);

        // 添加爱好复选框及标签
        hobbyLabel = new JLabel("爱好");
        hobbyLabel.setBounds(30, 110, 60, 30);
        panel.add(hobbyLabel);

        readingBox = new JCheckBox("阅读");
        readingBox.setBounds(100, 110, 80, 30);
        panel.add(readingBox);

        musicBox = new JCheckBox("音乐");
        musicBox.setBounds(190, 110, 80, 30);
        panel.add(musicBox);

        movieBox = new JCheckBox("电影");
        movieBox.setBounds(280, 110, 80, 30);
        panel.add(movieBox);

        // 添加个人介绍文本框
        introArea = new JTextArea(6, 20);
        JScrollPane scrollPane = new JScrollPane(introArea);
        scrollPane.setBounds(100, 150, 300, 150);
        panel.add(scrollPane);

        // 添加提交按钮
        submitButton = new JButton("提交");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String gender = "男";
                if (femaleButton.isSelected()) {
                    gender = "女";
                }
                String hobbies = "";
                if (readingBox.isSelected()) {
                    hobbies += "阅读 ";
                }
                if (musicBox.isSelected()) {
                    hobbies += "音乐 ";
                }
                if (movieBox.isSelected()) {
                    hobbies += "电影 ";
                }
                String intro = introArea.getText();

                JOptionPane.showMessageDialog(frame,
                        "姓名:" + name + "\n性别:" + gender + "\n爱好:" + hobbies + "\n介绍:" + intro,
                        "用户信息", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        submitButton.setBounds(200, 310, 80, 30);
        panel.add(submitButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Test10();
    }
}
