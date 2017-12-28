package chapter.thirteen.unit.two;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/7/22
 * Comment: Thinking in Java 13.2 重载 "+" 与 StringBuilder
 */
public class Concatenation {
    public static void main(String[] args) {
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
    }
}
