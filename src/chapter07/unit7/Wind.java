package chapter07.unit7;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.7.0 向上转型
 * “为新的类提供方法”并不是继承这一特性中最为重要的方面，其最重要的方面是表现新的类和基类之间的关心
 * tune() 方法接受的是 Instrument 对象的引用，但是在下面的代码中却传入了一个 Wind 类型的引用。
 * Java对类型的检查非常严格，你一定会觉得奇怪。
 * 除非你认识到 Wind 是 Instrument 的导出类，一个方法接受的参数可以是参数本身的类型，也可以是参数本身类型的导出类型。
 * 例如 toString(Object o) 它接受的是一个 object 的类型，那么我们可以传入任意 Java 对象类型作为参数，因为所有的 Java 对象类型都是 object 类型的子类。
 * 这种动作被称为“向上转型”
 */
public class Wind extends Instrument {
    public static void main(String[] args) {
        Wind wind = new Wind();
        Instrument.tune(wind);
    }
}
