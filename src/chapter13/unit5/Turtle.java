package chapter13.unit5;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/8/1
 * Comment: Thinking in Java 13.5.3 Formatter 类
 */
public class Turtle {
    private String name;
    private Formatter formatter;

    public Turtle(String name, Formatter formatter) {
        this.name = name;
        this.formatter = formatter;
    }

    public void move(int x, int y) {
        formatter.format("%s The Turtle is at (%d, %d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        Turtle tommy = new Turtle("Tommy", new Formatter(outAlias));
        Turtle terry = new Turtle("Terry", new Formatter(outAlias));
        tommy.move(1, 2);
        terry.move(3, 4);
        tommy.move(5, 6);
        terry.move(7, 8);
    }
}
