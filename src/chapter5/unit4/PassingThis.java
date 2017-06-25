package chapter5.unit4;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/5/13
 * Comment: Thinking in Java 5.4 this 关键字
 */
class Peeler {
    public static Apple peel(Apple apple) {
        System.out.println("Peeler class peel() method");
        return apple;
    }
}

class Person {
    public void eat(Apple apple) {
        System.out.println("Person class eat() method");
        Apple peeled = apple.getPeeled();
    }
}

class Apple {
    public Apple getPeeled() {
        System.out.println("Apple class getPeeled() method");
        return Peeler.peel(this);
    }
}

public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}
