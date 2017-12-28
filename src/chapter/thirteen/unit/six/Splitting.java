package chapter.thirteen.unit.six;

import java.util.Arrays;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/8/1
 * Comment: Thinking in Java 13.6.1 正则表达式基础
 */
public class Splitting {
    public static String knights = "Then, when you have found the shrubbery, " +
            "you must cut down the mightiest tree in the forest... with... a herring";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");
    }
}
