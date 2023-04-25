package com.t7h.test03;

public class Test03_2 {
    public abstract static class Animal {
        private final String name;           //定义私有属性name,表示动物名字
        private final int age;               //定义私有属性age,表示动物年龄
        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public abstract void eat();    //定义抽象方法eat()
        public abstract void sleep();   //定义抽象方法sleep()
        public String getName() {     //name属性的getter方法
            return name;
        }
        public int getAge() {         //age属性的getter方法
            return age;
        }
    }
    public interface Show {
        void showInfo();
    }
    public static class Dog extends Animal implements Show {
        public Dog(String name, int age) {
            super(name, age);
        }
        public void eat() {
            System.out.println("Eating...");
        }
        public void sleep() {
            System.out.println("Sleeping...");
        }
        public void showInfo() {
            System.out.println("Name: " + getName() + ", Age: " + getAge());
        }
    }
//    public class Cat extends Animal implements Show {
//    }   // 同Dog类
    public static class Test {
        public static void main(String[] args) {
            Dog d = new Dog("Husky", 5);       //创建Dog对象
            d.eat();                           //调用eat()方法
            d.sleep();                         //调用sleep()方法
            d.showInfo();                     //调用showInfo()方法
            ((Animal) d).eat();                          //调用的是Dog的eat()方法
            ((Animal) d).sleep();                        //调用的是Dog的sleep()方法
            // a.showInfo();                  //编译不通过,Animal没有showInfo()方法
            ((Show) d).showInfo();                     //调用的是Dog的showInfo()方法
            d.eat();
            d.sleep();
            d.showInfo();
            /*
            (b)
            虽然可以调用Dog类重写的eat()和sleep()方法:
            a.eat();                          //调用的是Dog的eat()方法
            a.sleep();                        //调用的是Dog的sleep()方法
            但是不能调用Dog类特有的showInfo()方法:
            a.showInfo();                //编译不通过,Animal没有showInfo()方法
            这是因为Animal类中没有showInfo()这个方法,只有Dog类实现了这个方法。虽然a变量引用的对象是Dog类型的,但由于编译时类型是Animal,
            所以只能调用Animal类中的方法,无法调用Dog新增的方法。这就是多态的限制,动态绑定只适用于继承的方法,对于子类新增的方法无能为力。
            所以,虽然可以将子类对象赋给父类变量,但在使用时需要注意,只能调用父类中定义的方法,子类新增的方法需要进行向下转型才能调用。
            这个问题的解决方法是进行向下转型:
            Dog d2 = (Dog)a;    //向下转型
            d2.showInfo();      //现在可以调用showInfo()方法了
            总结:父类引用指向子类对象,可以调用继承的方法,但不能调用子类新增的方法,需要向下转型后才可以调用。
             */
            /*
            (c)
            Show s = d;         //可以将Dog对象赋给Show变量
            这是因为Dog类实现了Show接口,所以Dog对象也属于Show类型,可以赋给Show变量。
            调用showInfo()方法没有问题:
            s.showInfo();      //调用的是Dog的showInfo()方法
            但是调用eat()和sleep()方法会编译错误:
            s.eat();           //编译错误,Show接口没有eat()方法
            s.sleep();         //编译错误,Show接口没有sleep()方法
            这是因为Show接口中只定义了showInfo()方法,并没有eat()和sleep()方法。
            将Show变量赋值给Dog变量需要进行向下转型:
            Dog d2 = (Dog)s;   //需要向下转型
            转型后,就可以调用Dog类的所有方法了:
            d2.eat();
            d2.sleep();
            d2.showInfo();
            总结:接口变量可以引用实现该接口的类的对象,但只能调用接口中定义的方法。如果想调用类特有的方法,需要向下转型为类类型。
            接口只规定了可调用的方法,没有方法实现,实现接口的类需要提供方法实现,所以接口变量调用方法时,实际执行的是实现类中对接口方法的实现。
             */

        }
    }
}
