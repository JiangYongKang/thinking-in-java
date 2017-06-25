package chapter7.unit4;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.4.1
 */
public class Circle extends Shape {
    public Circle(int i) {
        super(i);
        System.out.println("Drawing Circle");
    }

    @Override
    public void dispose() {
        System.out.println("Erasing Circle");
        super.dispose();
    }
}
