package chapter13.unit6;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/8/1
 * Comment: Thinking in Java 13.6.1 正则表达式基础
 */
public class Replacing {
    static String s = Splitting.knights;

    public static void main(String[] args) {
        System.out.println(s.replaceFirst("f\\w+", "located"));
        System.out.println(s.replaceAll("shrubbery|tree|herring", "banana"));
    }
}
