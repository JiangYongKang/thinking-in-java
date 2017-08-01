package chapter13.unit6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/8/1
 * Comment: Thinking in Java 13.6.7 reset()
 */
public class Resetting {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        matcher.reset("fix the rig with bags");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
