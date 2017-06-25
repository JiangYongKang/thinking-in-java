package chapter1.unit7;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/5/7
 * Comment: Thinking in Java 1.7 伴随多态的可互换对象
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 虽然 BirdController 中的 reLocate 方法的参数声明的是必须传入一个 Bird 类型的对象。
         * 但是其 Bird 类的两个子类 Goose 和 Penguin 依然也可以传入到该方法中，并正确运行。
         * 面向对象程序语言中使用了 "后期绑定" 这一概念。
         * 即在程序运行时，才能知道被调用方法的代码在计算机中的地址，与此同时，进行参数和返回值的类型检查。
         * 这种概念也成为 "动态绑定"。
         * 在 Java 中，动态绑定是自动执行的。不需要人工干预。
         * 如 C++ 中，需要借助 "virtual" 关键字来达到同样的目的。
         */
        BirdController controller = new BirdController();

        Bird bird = new Bird();
        Goose goose = new Goose();
        Penguin penguin = new Penguin();

        /**
         * "goose"、"penguin" 均为 Bird 的子类对象，但是却可以自动向上转型为 Bird 对象。
         */
        controller.reLocate(bird);
        controller.reLocate(goose);
        controller.reLocate(penguin);
    }
}
