package chapter.ten.unit.three;

/**
 * Author: vincent
 * Date: 2017-12-28 13:55:00
 * Comment: Think in Java 使用.this 和 .new 练习题
 */
public class Outer {
    public Outer() {
        System.out.println("create outer");
    }

    class Inner {
        public Inner() {
            System.out.println("create inner");
        }
    }

    static class StaticInner {
        public StaticInner() {
            System.out.println("create static inner");
        }
    }
}
