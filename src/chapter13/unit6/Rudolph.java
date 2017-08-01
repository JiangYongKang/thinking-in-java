package chapter13.unit6;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/8/1
 * Comment: Thinking in Java 13.6.2 正则表达式基础
 */
public class Rudolph {
    public static void main(String[] args) {
        for (String pattern : new String[]{"Rudolph", "[rR]udolph", "[rR][aeiou][a-z]ol.*", "R.*"}){
            System.out.println("Rudolph".matches(pattern));
        }
    }
}
