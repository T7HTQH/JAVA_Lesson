package com.t7h.Test05;

import java.util.*;

public class Test05 {
    /**
     * @param sno  学号
     * @param name 姓名
     */ // 定义Student类
    public record Student(String sno, String name) {

    }

    public static class Test {
        public static void main(String[] args) {
            // (2)使用ArrayList添加10个Student,并遍历
            ArrayList<Student> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(new Student(String.valueOf(i), "name" + i));
            }
            Iterator<Student> it = list.iterator();
            while (it.hasNext()) {
                Student s = it.next();
                System.out.println(s.sno() + ", " + s.name());
            }

            // (3)使用HashSet添加5个Student,检查重复并遍历
            HashSet<Student> set = new HashSet<>();
            set.add(new Student("1", "a"));
            set.add(new Student("2", "b"));
            set.add(new Student("1", "c"));  //重复的学号
            set.add(new Student("3", "d"));
            set.add(new Student("4", "e"));
            for (Student s : set) {
                System.out.println(s.sno() + ", " + s.name());
            }

            // (4)使用TreeSet添加10个Student,并按学号排序遍历
            TreeSet<Student> ts = new TreeSet<>(Comparator.comparing(Student::sno));
            // 添加10个Student...

            for (Student s : ts) {
                System.out.println(s.sno() + ", " + s.name());
            }

            // (5)对ArrayList做各种操作
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list2.add(i);
            }
            // 排序
            Collections.sort(list2);
            System.out.println(list2);

            // 反转
            Collections.reverse(list2);
            System.out.println(list2);

            // 随机置换
            Collections.shuffle(list2);
            System.out.println(list2);

            // (6)函数式编程示例
            list2.forEach(System.out::println);
        }
    }
}

/*
Java 8新增了许多函数式编程的特性,这里举一个简单的例子:
Lambda表达式:
java
// Lambda表达式
list.forEach(x -> System.out.println(x));
这是一个简单的Lambda表达式,用于遍历list集合并打印每个元素。
相比于传统的匿名内部类写法:
java
list.forEach(new Consumer<Integer>() {
    @Override
    public void accept(Integer x) {
        System.out.println(x);
    }
});
Lambda表达式更加简洁,去掉了大括号、return关键字以及方法名字。
Lamdba表达式的基本语法是:
(parameters) -> expression
或者
(parameters) -> { statements; }
它包含以下要素:
- 参数列表:即lambda表达式中所需的参数,与函数方法的参数列表相同。
- 箭头:将参数列表与lambda主体分隔开。
- 主体:包含了表达式或语句块,其中表达式相当于方法的返回值。
- 如果主体只有一条语句,那么可以不使用大括号{}和return关键字,表达式的结果即为lambda的返回值。否则需要使用大括号{}和return语句。
所以这是一个Java 8添加的简洁而强大的新特性,极大的提高了Java的函数式编程能力。Lambda表达式在集合遍历、线程等场景下得到广泛应用。
除了Lambda表达式,Java 8还添加了方法引用、默认方法、Stream API等重要特性,极大的丰富了Java的函数式编程工具箱。这也使Java 8成为Java发展历程中的一个重要里程碑。
 */
