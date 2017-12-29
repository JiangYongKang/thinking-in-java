package chapter.ten.unit.eight.zero;

/**
 * Author: vincent
 * Date: 2017-12-28 17:15:00
 * Comment: Think in Java 10.8.0 为什么需要内部类
 * 内部类可以解决多重继承的问题
 * 内部类可以有多个实例，每个实例都有自己的状态信息，并且与外部类对象的信息相互独立
 * 在外部类中，可以让多个内部类以不同的方式实现同一个接口，或继承同一个类
 * 创建内部类对象并不依赖外部类的创建
 * 内部类并没有令人迷惑的 is-a 关系，它是一个独立的实体
 */
interface InterfaceOne {
}

interface InterfaceTwo {
}

class ClassOne implements InterfaceOne, InterfaceTwo {
}

class ClassTwo implements InterfaceOne {
    InterfaceTwo makeInterfaceTwo() {
        return new InterfaceTwo() {
        };
    }
}

public class MultiInterfaces {
    private static void tasksClassOne(InterfaceOne one) {}
    private static void tasksClassTwo(InterfaceTwo two) {}

    public static void main(String[] args) {
        ClassOne one = new ClassOne();
        ClassTwo two = new ClassTwo();
        tasksClassOne(one);
        tasksClassOne(two);
        tasksClassTwo(one);
        tasksClassTwo(two.makeInterfaceTwo());
    }
}
