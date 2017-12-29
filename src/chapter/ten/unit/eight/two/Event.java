package chapter.ten.unit.eight.two;

/**
 * Author: vincent
 * Date: 2017-12-29 13:16:00
 * Comment: Think in Java 10.8.2 内部类与控制框架
 * 应用程序框架就是被设计用于解决某类特定问题的一个或者一组类
 * 要运用某个应用程序框架，通常是继承一个类，并覆盖某些方法
 * 设计总是将变化的事物与不变的事物分离，模板方法是保持不变的事物，而可覆盖的方法就是变化的事物
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
    }

    public void start() {
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}
