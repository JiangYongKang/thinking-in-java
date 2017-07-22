package chapter13.unit1;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/7/22
 * Comment: Thinking in Java 13.1 不可变 String
 * String 对象时不可变的，String 类中每一个看起来像是会修改 String 值得方法，实际上都是创建了一个新的 String 对象
 */
public class Immutable {
    // 每当把 String 对象作为方法的参数时，都会复制一份引用，而并非直接对传入的参数进行操作
    private static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s);
        String ss = Immutable.upcase(s);
        System.out.println(ss);
    }
}
