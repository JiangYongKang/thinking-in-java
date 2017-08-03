package chapter07.unit4;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.4.1
 */
public class Line extends Shape {
    private int start, end;

    public Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("Drawing Line: " + start + ", " + end + "");
    }

    @Override
    public void dispose() {
        System.out.println("Erasing Line: " + start + ", " + end + "");
        super.dispose();
    }
}
