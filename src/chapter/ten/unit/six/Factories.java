package chapter.ten.unit.six;

/**
 * Author: vincent
 * Date: 2017/7/10
 * Comment: Thinking in Java 10.6.1 工厂方法
 */
class Implementation1 implements Service {

    private Implementation1() {
    }

    @Override
    public void methodOne() {
        System.out.println("Implementation1 -> methodOne()");
    }

    @Override
    public void methodTwo() {
        System.out.println("Implementation1 -> methodTwo()");
    }

    public static ServiceFactory factory = Implementation1::new;
}

class Implementation2 implements Service {

    private Implementation2() {
    }

    @Override
    public void methodOne() {
        System.out.println("Implementation2 -> methodOne()");
    }

    @Override
    public void methodTwo() {
        System.out.println("Implementation2 -> methodTwo()");
    }

    public static ServiceFactory factory = Implementation2::new;
}

public class Factories {

    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.methodOne();
        service.methodTwo();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);
    }
}
