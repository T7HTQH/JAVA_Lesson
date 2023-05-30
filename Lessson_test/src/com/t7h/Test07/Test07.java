package com.t7h.Test07;

public class Test07 {

    public static class MyThread extends Thread {
        //定义MyThread类,继承Thread线程类
        @Override
        public void run() {
//重写run()方法, run()方法中定义线程要执行的任务
            for (int i = 2; i <= 100; i++) {
                if (isPrime(i)) {
//调用isPrime()方法判断i是否为素数
                    System.out.println(getName() + ": " + i + "是素数");
                }
            }
            try {
                Thread.sleep((long) (Math.random() * 1000));
//使线程睡眠随机0-1000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "结束");
//打印线程结束语句
        }

        public boolean isPrime(int n) {
//定义isPrime()方法,判断n是否为素数
            if (n <= 1) return false;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }

    public static class MyRunnable implements Runnable {
        //定义MyRunnable类,实现Runnable接口
        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                if (i % 3 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + i + "能被3整除");
                }
            }
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }

    public static class Test {
        public static void main(String[] args) {
            MyThread t1 = new MyThread();
            t1.start();
//启动线程t1

            MyRunnable r = new MyRunnable();
            Thread t2 = new Thread(r);
            t2.start();
//以Runnable对象r为参数启动线程t2
        }
    }
}

// 多线程同步的方法:
// 1. synchronized:同步方法和同步块,使用在同一对象实例上
// 2. ReentrantLock:使用lock()和unlock()方法
// 3. 使用volatile关键字:当变量被声明为volatile时,会强制所有线程在使用这个变量时都去主存中读取该变量的值
// 4. 使用原子类:AtomicInteger, AtomicLong等
// 5. wait()和notify():用于线程间通信和等待

