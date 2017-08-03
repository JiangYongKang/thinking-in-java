package chapter07.unit4;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.4.1
 */
public class Triangle extends Shape {
    public Triangle(int i) {
        super(i);
        System.out.println("Drawing Triangle");
    }

    @Override
    public void dispose() {
        System.out.println("Erasing Triangle");
        super.dispose();
    }
}
