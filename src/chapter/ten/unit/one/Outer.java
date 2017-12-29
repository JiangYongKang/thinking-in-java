package chapter.ten.unit.one;

/**
 * Author: vincent
 * Date: 2017-12-28 11:04:00
 * Comment: Think in Java 10.1 练习（一）
 */
public class Outer {

    // 内部类
    class Inner {
        public Inner() {
            System.out.println("constructor inner");
        }
    }

    // 返回一个内部类的引用
    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        // 返回内部类的引用
        Outer.Inner inner = new Outer().inner();
    }
}
