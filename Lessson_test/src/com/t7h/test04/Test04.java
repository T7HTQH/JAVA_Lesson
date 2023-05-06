package com.t7h.test04;



public class Test04 {
    //自定义异常类InvalidAgeException
    public static class InvalidAgeException extends Exception {
        //有参构造方法
        public InvalidAgeException(String message) {
            super(message);
        }
        //无参构造方法
        public InvalidAgeException() {
            super();
        }
    }

    //People类
    public static class People {
        //setAge方法,参数为年龄age
        public void setAge(int age) throws InvalidAgeException {
            //如果age小于0,抛出InvalidAgeException异常
            if (age < 0) {
                throw new InvalidAgeException("年龄值无效");
            }
        }
    }

    //测试类
    public static class Test {
        public static void main(String[] args) {
            //创建People对象p
            People p = new People();
            //调用setAge方法,并捕获异常
            try {
                p.setAge(-10);
            } catch (InvalidAgeException e) {
                //打印异常信息
                System.out.println(e.getMessage());
            }
        }
    }
}

/*Java 1.7引入的新特性TWR(Try-With-Resource)的说明:
        - TWR是一种新的异常处理机制,用于简化资源的申请和释放。
        - TWR的语法是:在try括号中申明需要关闭的资源,这些资源会在try语句执行完毕后自动关闭。
        语法格式:
        java
        try (Resource1 r1 = ...;  Resource2 r2 = ...) {
        // use resource r1 and r2
        }
        - 使用TWR的好处是:简化了异常处理代码,资源可以保证被正确关闭,即使异常被抛出。不需要finally块来手动关闭资源。
        - TWR适用于实现AutoCloseable接口的资源,比如InputStream、OutputStream等。
        所以,TWR是Java 1.7提供的一个非常方便的异常处理机制,可以简化我们代码中资源申请和释放的工作,并确保资源被正确关闭,从而避免资源泄露等问题。*/
