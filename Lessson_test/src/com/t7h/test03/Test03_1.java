package com.t7h.test03;

public class Test03_1
{
    public static class Student {
        private final String name;       //定义私有属性name,表示学生姓名
        private final int age;          //定义私有属性age,表示学生年龄
        public Student(String name, int age) {    //构造方法,用于初始化name和age属性
            this.name = name;
            this.age = age;
        }
        public void showInfo() {
            System.out.println("Name: " + name + ", Age: " + age); //显示学生信息的方法
        }
    }
    public static class Undergraduate extends Student {   //Undergraduate类继承Student类
        private final String degree;
        public Undergraduate(String name, int age, String degree) {   //构造方法,用于初始化 name、age和degree属性
            super(name, age);
            this.degree = degree;
        }
        public void showInfo() {
            super.showInfo();          //调用父类的showInfo()方法
            System.out.println("Degree: " + degree);   //显示度属性
        }
    }
    public static class Test {
        public static void main(String[] args) {
            Test03_1.Student s = new Test03_1.Student("John", 20);      //创建Student对象
            s.showInfo();                           //调用showInfo()方法
            Test03_1.Undergraduate u = new Test03_1.Undergraduate("Tom", 22, "Bachelor");//创建Undergraduate对象
            u.showInfo();                           //调用showInfo()方法
        }
    }
}
