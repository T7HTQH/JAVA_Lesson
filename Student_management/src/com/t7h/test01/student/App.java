package com.t7h.test01.student;

import java.util.Scanner;

public class App {

    public static void main(String[] args){

        while(true)
        {
            System.out.println("************学生信息管理系统*************");
            System.out.println("            1.添加学生");
            System.out.println("            2.查看所有学生");
            System.out.println("            3.根据学号查找学生");
            System.out.println("            4.根据姓名查找学生");
            System.out.println("            5.修改学生");
            System.out.println("            6.删除学生");
            System.out.println("            7.退出系统");
            System.out.println("**************************************");
            System.out.println("请输入相应的数字进行操作：");
            Scanner scanner=new Scanner(System.in);
            int input = scanner.nextInt();
            if(input==7)
            {
                break;
            }
            else
            {
                doAction(input);
            }
        }

    }
    public  static void doAction(int i)
    {
        switch(i)
        {
            case 1:
                add();
                break;
            case 2:
                viewall();
                break;
            case 3:
                searchByNo();
                break;
            case 4:
                searchByName();
                break;
            case 5:
                modify();
                break;
            case 6:
                delete();
                break;
            default:
                System.out.println("输入的数字不合法");
                break;
        }

    }
    public static void add()
    {
        System.out.println("1.添加学生");
    }
    public static void viewall()
    {
        System.out.println("2.查看所有学生");
    }
    public static void searchByNo()
    {
        System.out.println("3.通过姓名查找学生");
    }
    public static void searchByName()
    {
        System.out.println("4.通过学号查找学生");
    }
    public static void modify()
    {
        System.out.println("5.修改学生");
    }
    public static void delete()
    {
        System.out.println("6.删除学生");
    }

}
