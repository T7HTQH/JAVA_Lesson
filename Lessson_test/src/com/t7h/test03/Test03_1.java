package com.t7h.test03;

public class Test03_1
{
    public static class Student {
        private  String name;
        private  int age;
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public void showInfo() {

            System.out.println("Name: " + name + ", Age: " + age);
        }
    }
    public static class Undergraduate extends Student {
        private String degree;
        public Undergraduate(String name, int age, String degree) {
            super(name, age);
            this.degree = degree;
        }
        public void showInfo() {
            super.showInfo();
            System.out.println("Degree: " + degree);
        }
    }
    public static class Test {
        public static void main(String[] args) {
            Test03_1.Student s = new Test03_1.Student("aaa", 20);
            s.showInfo();
            Test03_1.Undergraduate u = new Test03_1.Undergraduate("bbb", 22, "ccc");
            u.showInfo();
        }
    }
}
