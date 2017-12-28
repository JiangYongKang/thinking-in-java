package chapter.thirteen.unit.five;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/7/22
 * Comment: Thinking in Java 13.5.2 格式化输出
 */
public class SimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y = 5.23424;
        System.out.println("Row 1: [" + x + " " + y + "]");
        System.out.format("Row 1: [%d %.2f]\n", x, y);
        System.out.printf("Row 1: [%d %f]\n", x, y);
    }
}
