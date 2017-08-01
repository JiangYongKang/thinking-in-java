package chapter13.unit6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/8/1
 * Comment: Thinking in Java 13.6.4 Pattern 和 Matcher
 */
public class TestRegularExpression {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:\njava TestRegularExpression characterSequence regularExpression");
            System.exit(0);
        }
        System.out.println("Input: \"" + args[0] + "\"");
        for (String arg : args) {
            System.out.println("Regular expression: \"" + "\"");
            Pattern pattern = Pattern.compile(arg);
            Matcher matcher = pattern.matcher(args[0]);
            while (matcher.find()) {
                System.out.println("Match \"" + matcher.group() + "\" at positions "
                        + matcher.start() + "-" + (matcher.end() - 1));
            }
        }
    }
}
