package chapter.ten.unit.eleven;

/**
 * Author: vincent
 * Date: 2017-12-29 14:47:00
 * Comment: Thinking in Java 10.11 局部内部类
 */
interface Counter {
    int next();
}

public class LocalInnerClass {
    private int count = 0;

    Counter counterOne(final String name) {
        class LocalCounter implements Counter {
            public LocalCounter() {
                System.out.println("LocalCounter");
            }

            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        }
        return new LocalCounter();
    }

    /**
     * 匿名内部类是没有构造方法的，另外一点就是当需要多个实例对象的时候，应该考虑的是局部内部类，而不是匿名内部类
     * @param name
     * @return
     */
    Counter counterTwo(final String name) {
        return new Counter() {
            {
                System.out.println("Counter()");
            }

            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass innerClass = new LocalInnerClass();

        Counter counterOne = innerClass.counterOne("Local inner");
        Counter counterTwo = innerClass.counterTwo("Anonymous inner");

        for (int i = 0; i < 5; i++)
            System.out.println(counterOne.next());
        for (int i = 0; i < 5; i++)
            System.out.println(counterTwo.next());
    }
}
