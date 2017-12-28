package chapter.thirteen.unit.six;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/8/1
 * Comment: Thinking in Java 13.6.8 正则表达式与 Java I/O
 */
public class JGrep {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern pattern = Pattern.compile(args[1]);
        int index = 0;
        Matcher matcher = pattern.matcher("");
        /*for (String line : new TextFile(args[0])) {
            matcher.reset(line);
            while (matcher.find()) {
                System.out.println(index++ + ": " + matcher.group() + ": " + matcher.start());
            }
        }*/
    }
}
