package chapter.thirteen.unit.three;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/7/22
 * Comment: Thinking in Java 13.3.2 无意识的递归
 * 当调用 InfiniteRecursion.toString() 方法时，"+" 被重载
 * 编译器会试图将 "this" 转换为字符串，也就是它会调用 this 的 toString() 方法!
 * 于是乎，发生了递归调用，接着就会抛出异常
 */
public class InfiniteRecursion {
    @Override
    public String toString() {
        return "InfiniteRecursion{}" + this;
    }

    public static void main(String[] args) {
        // 运行代码将会得到一个 Exception in thread "main" java.lang.StackOverflowError 异常
        System.out.println(new InfiniteRecursion().toString());
    }
}
