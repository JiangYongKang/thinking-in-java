package chapter.ten.unit.five;

/**
 * Author: vincent
 * Date: 2017-12-28 15:02:00
 * Comment: Thinking in Java 10.5 练习
 */
public class Outer {
    public int value() {
        class Inner implements Contents {
            @Override
            public int value() {
                return 100;
            }
        }
        return new Inner().value();
    }

    public static void main(String[] args) {
        System.out.println(new Outer().value());
    }
}
