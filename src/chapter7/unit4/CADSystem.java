package chapter7.unit4;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.4.1 确保正确的清理
 * 基类对象与导出类对象之间的初始化和销毁顺序
 */
public class CADSystem extends Shape {
    private Circle circle;
    private Triangle triangle;
    private Line[] lines = new Line[3];

    public CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j++) {
            lines[j] = new Line(j, j * j);
        }
        circle = new Circle(i);
        triangle = new Triangle(i);
        System.out.println("Combined constructor");
    }

    @Override
    public void dispose() {
        System.out.println("CADSystem dispose()");
        triangle.dispose();
        circle.dispose();
        for (int i = 0; i < lines.length; i++) {
            lines[i].dispose();
        }
        super.dispose();
    }

    public static void main(String[] args) {
        CADSystem system = new CADSystem(47);
        try {

        } finally {
            system.dispose();
        }
    }
}
