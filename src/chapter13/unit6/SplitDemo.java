package chapter13.unit6;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/8/1
 * Comment: Thinking in Java 13.6.5 split()
 */
public class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input)));
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input, 3)));
    }
}
