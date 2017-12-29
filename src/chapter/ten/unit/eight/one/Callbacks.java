package chapter.ten.unit.eight.one;

/**
 * Author: vincent
 * Date: 2017-12-29 11:32:00
 * Comment: Think in Java 10.8.1 闭包与回调
 */
interface Increment {
    void increment();
}

class MyIncrement {
    public void increment() {
        System.out.println("other operation");
    }

    static void method(MyIncrement increment) {
        increment.increment();
    }
}

/**
 * 简单的解决方式就是直接去实现 Increment 接口
 */
class CalleeOne implements Increment {
    private int i = 0;

    @Override
    public void increment() {
        System.out.println(++i);
    }
}

/**
 * CalleeTwo 已经继承了 MyIncrement 并且重写了 increment() 方法
 * 虽然这时候再 implements Increment 是可以的，但是 increment() 方法的实现与 Increment 接口期望的实现完全不相关
 * 那么这个时候就可以使用内部类来实现 Increment 接口
 */
class CalleeTwo extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        System.out.println(++i);
    }

    private class Closure implements Increment {
        @Override
        public void increment() {
            CalleeTwo.this.increment(); // 等同于调用 new CalleeTwo().increment();
        }
    }

    Increment callbackReference() {
        return new Closure();
    }
}

class Caller {
    private Increment callbackReference;

    Caller(Increment increment) {
        callbackReference = increment;
    }

    void go() {
        callbackReference.increment();
    }
}

public class Callbacks {
    public static void main(String[] args) {
        CalleeOne one = new CalleeOne();
        CalleeTwo two = new CalleeTwo();

        MyIncrement.method(two);
        Caller callerOne = new Caller(one);
        Caller callerTwo = new Caller(two.callbackReference());

        callerOne.go();
        callerOne.go();
        callerTwo.go();
        callerTwo.go();
    }
}
