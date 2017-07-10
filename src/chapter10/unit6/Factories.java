package chapter10.unit6;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/10
 * Comment: Thinking in Java 10.6.1 工厂方法
 */
class Implementation1 implements Service {

    private Implementation1() {
    }

    @Override
    public void mothod1() {
        System.out.println("Implementation1 -> mothod1()");
    }

    @Override
    public void mothod2() {
        System.out.println("Implementation1 -> mothod2()");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation1();
        }
    };
}

class Implementation2 implements Service {

    private Implementation2() {
    }

    @Override
    public void mothod1() {
        System.out.println("Implementation2 -> mothod1()");
    }

    @Override
    public void mothod2() {
        System.out.println("Implementation2 -> mothod2()");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };
}

public class Factories {

    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.mothod1();
        service.mothod2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);
    }
}
