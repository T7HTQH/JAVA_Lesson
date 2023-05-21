package com.t7h.Test07;

public class Test07 {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 2; i <= 100; i++) {
                if (isPrime(i)) {
                    System.out.println(getName() + ": " + i + "是素数");
                }
            }
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "结束");
        }

        public boolean isPrime(int n) {
            if (n <= 1) return false;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }

    public static class MyRunnable implements Runnable {
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

            MyRunnable r = new MyRunnable();
            Thread t2 = new Thread(r);
            t2.start();
        }
    }

// 多线程同步的方法:
// 1. synchronized:同步方法和同步块,使用在同一对象实例上
// 2. ReentrantLock:使用lock()和unlock()方法
// 3. 使用volatile关键字:当变量被声明为volatile时,会强制所有线程在使用这个变量时都去主存中读取该变量的值
// 4. 使用原子类:AtomicInteger, AtomicLong等
// 5. wait()和notify():用于线程间通信和等待
}
